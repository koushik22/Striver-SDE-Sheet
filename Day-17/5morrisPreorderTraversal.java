// Intuition

// It is similar to Morris Inorder traversal, only we need to understand the way we are traversing the tree, It will travel as root→left→right. So when we’ll make or create the thread for ‘cur’ node, then itself, we’ll add this cur node in our answer.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        TreeNode cur = root;
        
        while(cur != null){
            if(cur.left == null){
                preOrder.add(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = cur;
                    preOrder.add(cur.val);
                    cur = cur.left;
                }
                else{ // prev->right == curr
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preOrder;
    }
}