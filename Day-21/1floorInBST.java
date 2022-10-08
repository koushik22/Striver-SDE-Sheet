// Approach-1

// A simple solution is to traverse the tree using (Inorder or Preorder or Postorder) and keep track of closest smaller or same element. Time complexity of this solution is O(n) where n is total number of Nodes in BST.

// Approach - 2

// The idea is to avoid unnecessary recursive calls for the nodes for which we are sure that difference will increase. So we’ll try to move in such a way that we get closer to the answer and everytime we move we need to update the answer. We’ll return the ans if we reach null or we reach the exact key value.


// /*
//     Time Complexity: O(h)
//     Space Complexity: O(1)

//     Where 'h' is the height of the tree.
// */



public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int floor = -1;
        while(root != null){
            // If root -> data is smaller than the 'X', then we'll update the answer and move to the right
            if(root.data < X){
                floor = root.data;
                root = root.right;
            }
            // If root -> data is greater than the 'X'
            else if(root.data > X){
                root = root.left;
            }
            // If root -> data is greater than the 'X'
            else{
                return X;
            }
        }
        return floor;
    }