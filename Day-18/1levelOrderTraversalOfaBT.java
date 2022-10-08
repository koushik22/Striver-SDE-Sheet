// Problem Statement: Level order traversal of a binary tree. Given the root node of the tree and you have to print the value of the level of the node by level.
// Approach:

// The algorithm steps are stated as:

// Take a queue data structure and push the root node to the queue.
// Set a while loop which will run till our queue is non-empty.
// In every iteration, pop out from the front of the queue and assign it to a variable (say temp).
// If temp has a left child, push it to the queue.
// If temp has a right child, push it to the queue.
// At last push the value of the temp node to our “ans” data structure.

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size() != 0){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = que.removeFirst();
                list.add(node.val);
                if(node.left != null)que.addLast(node.left);
                if(node.right != null)que.addLast(node.right);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}