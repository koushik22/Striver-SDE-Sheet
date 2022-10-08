// Problem Statement: Flatten Binary Tree To Linked List. Write a program that flattens a given binary tree to a linked list.

// Note: 

// The sequence of nodes in the linked list should be the same as that of the preorder traversal of the binary tree.
// The linked list nodes are the same binary tree nodes. You are not allowed to create extra nodes.
// The right child of a node points to the next node of the linked list whereas the left child points to NULL.

// Follow this for intuition and detailed explanation https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/

// Intuition:
// The prospect of solving this problem in O(1) might look tricky in the beginning, but all you need to know is how preorder traversal works.
// The key intuition of this solution is to preserve the "Pre-Order" order as we go.

// So we maintain a pointer curr while going down the tree. If curr has a left child, we want to shift it to the right while preserving the order. This will be two step process.
// Create another pointer 'prev' to find the right most point in the left subtree. Then we shift the contents of curr.right into prev.right. The tree which we have right now if you notice, still gives the exact same preorder traversal. So now we just shift this to the right of curr.

// Move curr to the right and repeat.

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right != null)prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;            
        }
    }
}