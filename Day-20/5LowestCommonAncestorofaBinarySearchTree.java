// Intuition:
// Just walk down from the whole tree's root as long as both p and q are in the same subtree (meaning their values are both smaller or both larger than root's). This walks straight from the root to the LCA, not looking at the rest of the tree,



public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}


// Approach-2

// Another approach could be finding root to node path for both the nodes separately and filling the paths in separate two
// arraylists for bothe the node. Then compare from the root position, whenever there is a node which is not in path for both the nodes, the node previous to that will be our answer

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // calculate root to node path in an arraylist
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        
        findPath(root , p , l1);
        findPath(root , q , l2);
        
        int i = 0 , j = 0;
        TreeNode prev = null;
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) == l2.get(i)){
                prev = l1.get(i);
                i++;
                j++;
            }
            else{
                break;
            }
        }
        return prev;
    }
    
    private void findPath(TreeNode root , TreeNode tar , List<TreeNode> path){
        if(root == null)return;
        path.add(root);
        
        if(root.val < tar.val){
            findPath(root.right , tar , path);
        }
        else if(root.val > tar.val){
            findPath(root.left , tar , path);
        }
        else{
            return;
        }
    }   
