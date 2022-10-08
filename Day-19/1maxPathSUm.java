// Maximum Sum Path in Binary Tree

// Problem Statement: Write a program to find the maximum sum path in a binary tree. A path in a binary tree is a sequence of nodes where every adjacent pair of nodes are connected by an edge. A node can only appear in the sequence at most once. A path need not pass from the root. We need to find the path with the maximum sum in the binary tree.

// For Intuition and solution visit https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/

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
    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        // Array is passed to calculate the answer because in java variable can't be passed by reference
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root , maxValue);
        return maxValue[0];
    }
    int maxPathSumHelper(TreeNode root , int[] maxValue){
        if(root == null)return 0;
        int leftsum = Math.max(0 , maxPathSumHelper(root.left , maxValue));
        int rightsum = Math.max(0 , maxPathSumHelper(root.right , maxValue));
        
        maxValue[0] = Math.max(maxValue[0] , leftsum + rightsum + root.val);
        return Math.max(leftsum , rightsum) + root.val;
    }
}