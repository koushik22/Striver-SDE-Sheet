// We can easily build a BST for a given preorder sequence by recursively repeating the following steps for all keys in it:

// 1. Construct the root node of BST, which would be the first key in the preorder sequence.
// 2. Find index i of the first key in the preorder sequence, which is greater than the root node.
// 3. Recur for the left subtree with keys in the preorder sequence that appears before the i'th index (excluding the first index).
// 4. Recur for the right subtree with keys in the preorder sequence that appears after the i'th index (including the i'th index).


public static Node constructBST(int[] preorder, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // Construct the root node of the subtree formed by keys of the
        // preorder sequence in range `[start, end]`
        Node node = new Node(preorder[start]);
 
        // search the index of the first element in the current range of preorder
        // sequence larger than the root node's value
        int i;
        for (i = start; i <= end; i++)
        {
            if (preorder[i] > node.key) {
                break;
            }
        }
 
        // recursively construct the left subtree
        node.left = constructBST(preorder, start + 1, i - 1);
 
        // recursively construct the right subtree
        node.right = constructBST(preorder, i, end);
 
        // return current node
        return node;
    }


    // The time complexity of the above solution is O(n^2), where n is the size of the BST, and requires space proportional to the tree’s height for the call stack.

 /*----------------------------------------------------------------------------------------------------------------------*/ 

// Better Solution( O(nlogn + o(n) time complexity)
// In this approach we'll convert the preorder array into a inorder array and then construct the BST from the property of
// 'creating BST using Inorder and preorder'

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


 /*----------------------------------------------------------------------------------------------------------------------*/ 


// Optimal Solution 


// Give the function a bound the maximum number it will handle.
// The left recursion will take the elements smaller than node.val
// The right recursion will take the remaining elements smaller than bound

// Complexity
// bstFromPreorder is called exactly N times.
// It's same as a preorder traversal.
// Time O(N)
// Space O(H)


    class Solution {
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder , new int[]{0} , Integer.MAX_VALUE);
    }
    
    private TreeNode build(int[] pre , int[] A , int bound){
        if(A[0] == pre.length || pre[A[0]] > bound)return null;
        TreeNode root = new TreeNode(pre[A[0]++]);
        root.left = build(pre , A , root.val);
        root.right = build(pre , A , bound);
        return root;
    }
}

// Comments

// we can solve the problem with only upper bound and no need of any lower bound. It's possible to do this because when you construct the left child the upper bound will be the node value itself and no lower bound will be needed; when you construct the right child the upper bound will be the same bound value as of node. Why right child lower bound is not needed? Because you come to the point to construct the right child after this element failed the requirement of becoming left element of the current node!