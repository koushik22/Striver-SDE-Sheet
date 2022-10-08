// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Approach 1: Recursion
// Intuition

// The two key observations are:

// Preorder traversal follows Root -> Left -> Right, therefore, given the preorder array preorder, we have easy access to the root which is preorder[0].

// Inorder traversal follows Left -> Root -> Right, therefore if we know the position of Root, we can recursively split the entire array into two subtrees.

// Now the idea should be clear enough. We will design a recursion function: it will set the first element of preorder as the root, and then construct the entire tree. To find the left and right subtrees, it will look for the root in inorder, so that everything on the left should be the left subtree, and everything on the right should be the right subtree. Both subtrees can be constructed by making another recursion call.

// It is worth noting that, while we recursively construct the subtrees, we should choose the next element in preorder to initialize as the new roots. This is because the current one has already been initialized to a parent node for the subtrees.

// The basic idea is here:
// Say we have 2 arrays, PRE and IN.
// Preorder traversing implies that PRE[0] is the root node.
// Then we can find this PRE[0] in IN, say it's IN[5].
// Now we know that IN[5] is root, so we know that IN[0] to IN[4] is on the left side, IN[6] to the end is on the right side.
// Recursively doing this on subarrays, we can build a tree out of it :)

// Hope this helps.

public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}

public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;