// Problem Statement: Check whether the given Binary Tree is a Balanced Binary Tree or not. A binary tree is balanced if, for all nodes in the tree, the difference between left and right subtree height is not more than 1.

// Solution

// Disclaimer: Don’t jump directly to the solution, try it out yourself first.

// Solution 1: Naive approach

// Intuition + Approach: 

// For a Balanced Binary Tree, Check left subtree height and right subtree height for every node present in the tree. Hence, traverse the tree recursively and calculate the height of left and right subtree from every node, and whenever the condition of Balanced tree violates, simply return false.

// Condition for Balanced Binary Tree

// For all Nodes , Absolute( Left Subtree Height – Right Subtree Height ) <= 1

// Time Complexity: O(N*N) ( For every node, Height Function is called which takes O(N) Time. Hence for every node it becomes N*N ) 

// Space Complexity: O(1) ( Extra Space ) + O(H) ( Recursive Stack Space where “H” is the height of tree )

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh - rh) > 1)return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(!left || !right)return false;
        return true;
    }
    private int height(TreeNode node){
        if(node == null)return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh , rh) + 1;
    }
}


// Solution 2: Post Order Traversal

// Intuition: Can we optimize the above brute force solution? Which operation do you think can be skipped to optimize the time complexity?

// Ain’t we traversing the subtrees again and again in the above example?

// Yes, so can we skip the repeated traversals?

// What if we can make use of post-order traversal?

// So, the idea is to use post-order traversal. Since, in postorder traversal, we first traverse the left and right subtrees and then visit the parent node, similarly instead of calculating the height of the left subtree and right subtree every time at the root node, use post-order traversal, and keep calculating the heights of the left and right subtrees and perform the validation.

// Approach : 

// 1. Start traversing the tree recursively and do work in Post Order.
// 2. For each call, caculate the height of the root node, and return it to previous calls.  
// 3. Simultaneously, in the Post Order of every node , Check for condition of balance as information of left and right subtree height is available.
// 4. If it is balanced , simply return height of current node and if not then return -1.
// 5. Whenever the subtree result is -1 , simply keep on returning -1.

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }
    int dfsHeight (TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// Time Complexity: O(N) 

// Space Complexity: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree)