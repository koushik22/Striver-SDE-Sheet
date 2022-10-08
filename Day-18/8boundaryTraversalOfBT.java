// Problem Statement: BoundaryTraversal of a binary tree. Write a program for the Anti-Clockwise Boundary traversal of a binary tree.

// Recursion Based Approach
// The boundary traversal of a binary tree can be broken down into 4 parts. These parts are given in the same order as they are present in the traversal-

 

// The root node - The root node will always be our first node in the whole boundary traversal.
 
// The left boundary - The left most nodes of the left subtree are also included in the boundary traversal, so we will process them next except for the leaf node as it will be processed in our next part. We can use recursion for this and traverse for only left child until a leaf node is encountered. If the left child is not present we recurse for the right child.
 
// The leaf Nodes - The leaf nodes of the binary tree will be processed next. We can use a simple inorder traversal for that. Inorder traversal will make sure that we process leaf nodes from left to right.
 
// The right boundary - The right most nodes of the right subtree will be processed at last in reverse order except for the leaf node as it is already processed in the previous part. For this, we can use recursion in a postorder manner and traverse for the right child only until we encounter a leaf node. If the right child is not present we will recurse for the left child. The postorder recursion will make sure that we traverse the right boundary in reverse order.
// Time Complexity
// O(N), where ‘N’ is the total number of nodes in the binary tree.

 

// Since we are traversing for left and right boundaries in a binary tree, and this will take at the most linear time. Also, traversing for leaf nodes can also be performed in linear time. Hence, the overall time complexity is O(N).


public class Main {
        static Boolean isLeaf(Node root) {
            return (root.left == null) && (root.right == null);
        }

        static void addLeftBoundary(Node root, ArrayList < Integer > res) {
            Node cur = root.left;
            while (cur != null) {
                if (isLeaf(cur) == false) res.add(cur.data);
                if (cur.left != null) cur = cur.left;
                else cur = cur.right;
            }
        }
        static void addRightBoundary(Node root, ArrayList < Integer > res) {
            Node cur = root.right;
            ArrayList < Integer > tmp = new ArrayList < Integer > ();
            while (cur != null) {
                if (isLeaf(cur) == false) tmp.add(cur.data);
                if (cur.right != null) cur = cur.right;
                else cur = cur.left;
            }
            int i;
            for (i = tmp.size() - 1; i >= 0; --i) {
                res.add(tmp.get(i));
            }
        }

        static void addLeaves(Node root, ArrayList < Integer > res) {
            if (isLeaf(root)) {
                res.add(root.data);
                return;
            }
            if (root.left != null) addLeaves(root.left, res);
            if (root.right != null) addLeaves(root.right, res);
        }
        public static ArrayList < Integer > printBoundary(Node node) {
            ArrayList < Integer > ans = new ArrayList < Integer > ();
            if (isLeaf(node) == false) ans.add(node.data);
            addLeftBoundary(node, ans);
            addLeaves(node, ans);
            addRightBoundary(node, ans);
            return ans;
        }
}