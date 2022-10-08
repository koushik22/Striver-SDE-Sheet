// Intuition : keep a valid range (starting from [-INFINITY, INFINITY]) and keep shrinking it down for each node as we go down recursively



class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root , long minVal , long maxVal){
        if(root == null)return true;
        
        if(root.val <= minVal || root.val >= maxVal)return false;
        return isValidBST(root.left , minVal , root.val) && isValidBST(root.right , root.val , maxVal);
    }
}