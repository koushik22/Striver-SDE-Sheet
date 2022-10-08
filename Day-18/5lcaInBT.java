//  Problem Statement: Given a binary tree, Find the Lowest Common Ancestor for two given Nodes (x,y).

//  Lowest Common Ancestor(LCA): The lowest common ancestor is defined between two nodes x and y as the lowest node in T that has both x and y as descendants (where we allow a node to be a descendant of itself.


// Solution:

// Disclaimer: Don’t jump directly to the solution, try it out yourself first.

// Intuition:

// The very first thing we can observe from the question is that we can find the LCA of 2 given nodes from 

//         i) Left subtree or in

//        ii)Right subtree, if not in both the subtrees then root will be the  LCA.

// Approach:

// 1. If root is null or if root is x or if root is y then return root
// 2. Made a recursion call for both
// i) Left subtree 

// ii)Right subtree

// Because we would find LCA in the left or right subtree only.

// 3. If the left subtree recursive call gives a null value that means we haven’t found LCA in the left subtree, which means we found LCA on the right subtree. So we will return right.
// 4. If the right subtree recursive call gives null value, that means we haven’t found LCA on the right subtree, which means we found LCA on the left subtree. So we will return left .
// 5. If both left & right calls give values (not null)  that means the root is the LCA.


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }
}

// Time complexity: O(N) where n is the number of nodes.

// Space complexity: O(N), auxiliary space.