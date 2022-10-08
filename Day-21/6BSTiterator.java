// Approach 1 : Do an inorder traversal of the tree and store the entries in an array with the current pointer set to the start of the array. hasNext checks if the pointer is less than the size of the array. next() would return the element at the current position incrementing the position by 1.
// However, this has an additional space complexity of O(N) where N = number of nodes in the tree.
// This might be an acceptable answer. Most interviewers would look for you to do better.

// Approach 2 : Lets look at the version of this problem when the trees have a back pointer. Can you solve the problem without using additional space ? When you are on node N and are asked for next element, you obviously won’t go to the left subtree as all the elements there are smaller than N. We would go to the smallest number in the right subtree if the right subtree is not null. If the right subtree is null, that means that we need to move up, and keep moving up till we are coming from the right subtree.
// Now we don’t have the back pointer in this case. So, we need something to keep track of the path from root to the current node, so we can move to the parent when needed. Do note that storing the path from root to the current node only requires memory equivalent to the length of the path which is the depth of the tree. Also, we can track the path using stack.


class BSTIterator {
    
    private Stack<TreeNode> st = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void pushAll(TreeNode node){
        for(; node != null; st.push(node) , node = node.left);
    }
}