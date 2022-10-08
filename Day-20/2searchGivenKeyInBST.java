// Intuition: We start from the root of our tree and compare value in its root. If value we are looking is less
//  than value in root, we go left, if it is more
// , we go to the right. When we stop? Either if we found place, where these two values are equal, or we reached NULL leaf (it means we visited leaf and descended to its NULL children). In this cases we return from there as we have found the answer.

// Recursive Solution
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)return null;
        if(root.val > val){
            TreeNode left = searchBST(root.left , val);
            if(left != null)return left;
        }
        else if(root.val < val){
            TreeNode right = searchBST(root.right , val);
            if(right != null)return right;
        }
        else{
            return root;
        }
        return null;
    }
}

// Iterative solution

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}

// TC - O(logn), 'logn' is height of the BST.
// SC - O(1)