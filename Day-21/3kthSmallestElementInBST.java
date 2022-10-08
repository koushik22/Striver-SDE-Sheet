// The idea is to traverse the BST in an inorder fashion since the inorder traversal visits the nodes of a BST in the sorted order. Maintain a counter along with recursion that keeps track of the visited nodes, and when that counter reaches k, return that node. As in java everything is pass by value, instead of passing a variable we need to pass an 2-sized array(arr[0]->to count the number of nodes we have visited, arr[1]->to store the answer).



class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] nums = new int[2];
        inorder(root , k , nums);
        return nums[1];
    }
    
    public void inorder(TreeNode root , int k , int[] nums){
        if(root == null){
            return;
        }
        inorder(root.left , k , nums);
        if(++nums[0] == k){
            nums[1] = root.val;
            return;
        }
        inorder(root.right , k , nums);
    }
}

// Time Complexity - O(n) in worst case
// Space Complexity - O(n) in worst case when the tree is a skewed tree