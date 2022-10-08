// If you notice carefully in the flattened tree, each node’s right child points to the next node of a pre-order traversal.

// Now, if a node does not have left node, then our problem reduces to solving it for the node->right.
// If it does, then the next element in the preorder traversal is the immediate left child. But if we make the immediate left child as the right child of the node, then the right subtree will be lost. So we figure out where the right subtree should go. In the preorder traversal, the right subtree comes right after the rightmost element in the left subtree.
// So we figure out the rightmost element in the left subtree, and attach the right subtree as its right child. We make the left child as the right child now and move on to the next node.


// 1st approach -> Recursive Approach

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
    }
}

// T.C -> O(N)
// S.C -> O(N)


// Iterative 
class Solution {

    public void flatten(TreeNode root) {
        if(root == null) return; 
        
        Deque<TreeNode> st = new ArrayDeque<>(); 
        st.push(root); 
        while(!st.isEmpty()) {
            TreeNode cur = st.peek();
            st.pop();
            
            if(cur.right != null) {
                st.push(cur.right); 
            }
            if(cur.left != null) {
                st.push(cur.left); 
            }
            if(!st.isEmpty()) {
                cur.right = st.peek(); 
            }
            cur.left = null;
        }
        
    }
}

// TC - O(N) 
// SC - O(1) 
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
		while (cur != null)
		{
			if(cur.left != null)
			{
				TreeNode pre = cur.left;
				while(pre.right != null)
				{
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
    }
}