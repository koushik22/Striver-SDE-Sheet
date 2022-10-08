// We will traverse the Binary search tree from the root node till we find the node whose key value is given, and upon getting that, we return the ceil value of it. And in the process we continue to update our answer. So if we reach null the last updated answer will be our ceil value


/*
    Time complexity: O(logN)
    Space complexity: O(logN)

    Where 'N' is the number of nodes of the tree
*/

public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Initializing ceil value
        int ceil = -1;

        // Traverse till the node is not null
        while (node != null) {

            // If node value equals key then return it
            if (x == node.data) {
                return node.data;
            }

            // Traverse right sub-tree
            if (x > node.data) {

                node = node.right;
            }

            // Traverse left sub-tree
            else {
                ceil = node.data;
                node = node.left;
            }
        }

        // Return the ceil value
        return ceil;

    }
}
