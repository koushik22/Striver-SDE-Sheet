// Problem Statement: Find the Maximum Depth of Binary Tree. Maximum Depth is the count of nodes of the longest path from the root node to the leaf node.

// Solution 1:

// Intuition + Approach: Using LEVEL ORDER TRAVERSAL

// If we observe carefully, the depth of the Binary Tree is the number of levels in the binary tree. So, if we simply do a level order traversal on the binary tree and keep a count of the number of levels, it will be our answer.

public class tUf {
    private static int levelOrder( Node root ){
        if( root == null ){
            return 0;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        int level = 0;

        while( queue.size() > 0 ){
            int size = queue.size();

            while( size-- > 0 ){
                Node remNode = queue.removeFirst();
                if( remNode.left != null ){
                    queue.addLast( remNode.left );
                }
                if( remNode.right != null ){
                        queue.addLast( remNode.right );
                }
            }

            level++;
        }

        return level;
    }  
}

// Time Complexity: O(N) 

// Space Complexity: O(N) ( Queue data structure is used )


// Solution 2:

// Intuition: Recursively ( Post Order Traversal )

// If we have to do it recursively, then what we can think of is, If I have Maximum Depth of Left subtree and Maximum Depth of Right subtree then what will be the height or depth of the tree?

// Exactly,

// 1 + max(depth of left subtree, depth of right subtree)
// So, to calculate the Maximum Depth, we can simply take the maximum of the depths of the left and right subtree and add 1 to it.

// Why take Maximum?? Because we need maximum depth so if we know left & right children’s maximum depth then we’ll definitely get to the maximum depth of the entire tree.

// Approach : 

// We start to travel recursively and do our work in Post Order.
//  Reason behind using Post Order comes from our intuition , that if we know the result of  left and right child then we can calculate the result using that. 
// This is exactly an indication of PostOrder, because in PostOrder we already calculated results for left and right children than we do it for current node.
// So for every node post order, we do Max( left result , right result ) + 1 and return it to the previous call.
// Base Case is when root == null so we need to return 0;


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        
        int lh = maxDepth(root.left); 
        int rh = maxDepth(root.right); 
        
        return 1 + Math.max(lh, rh); 
    }
}

// Time Complexity: O(N) 

// Space Complexity: O(1) Extra Space + O(H) Recursion Stack space, where “H”  is the height of the binary tree.