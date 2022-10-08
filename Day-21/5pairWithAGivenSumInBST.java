//  Solution 1: HashSet

// Same idea with the classic problem "Two Sum", we use a HashSet data structure to keep track of old elements. For a node.val, if we found its complement (k - node.val) then return TRUE.
// Here instead of traversing all elements in the array, we traverse all elements in the Binary Tree.
// But this solution doesn't take the advantage that our Binary Tree is a Binary Search Tree.


 public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    
    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

// Optimal Approach(Using Binary Tree Iterator)
// Since our Binary Tree is a Binary Search Tree, when we traverse elements in-order, elements are sorted.
// By using the idea from 173. Binary Search Tree Iterator problem, we can iterate in-order elements in the BST with O(H) in space complexity.
// Since our elements are sorted, we can use Two Pointer to search a pair of (left, right) so that left + right = k, where left point to left element in the BST, right point to right element in the BST.

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true; 
    
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse; 
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left); 
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        while(node != null) {
             stack.push(node);
             if(reverse == true) {
                 node = node.right; 
             } else {
                 node = node.left; 
             }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false; 
        BSTIterator l = new BSTIterator(root, false); 
        BSTIterator r = new BSTIterator(root, true); 
        
        int i = l.next(); 
        int j = r.next(); 
        while(i<j) {
            if(i + j == k) return true; 
            else if(i + j < k) i = l.next(); 
            else j = r.next(); 
        }
        return false; 
    }
}

// O(n) time O(log n) space

