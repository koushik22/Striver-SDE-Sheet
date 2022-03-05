// Inutuition

// 🌳1st case: if left is null, print current node and go right
// 🌳 2nd case: if there is a left, before going left, make right most node on left subtree connected to current node, then go left
// 🌳 3rd case: if thread is already pointed to current node, then remove the thread and go to right

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        TreeNode cur = root;
        
        while(cur != null){
            if(cur.left == null){
                inOrder.add(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{ // prev->right == curr
                    prev.right = null;
                    inOrder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inOrder;
    }
}