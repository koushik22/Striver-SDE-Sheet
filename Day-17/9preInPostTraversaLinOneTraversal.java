// Problem Statement: Preorder Inorder Postorder Traversals in One Traversal. Write a program to print Preorder, Inorder, and Postorder traversal of the tree in a single traversal.

// Problem Description: 

// We need to write a function allTraversals() which returns us three lists of a preorder, inorder and postorder traversals of the tree at the same time. We are not allowed to write separate codes for each traversal. We want all traversals in a single piece of code, in a single instance.

// For intuition and explanation visit : https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
}
class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}
public class TUF {
    public static void allTraversal(TreeNode root, List < Integer > pre, List < Integer > in , List < Integer > post) {
        Stack < Pair > st = new Stack < Pair > ();
        st.push(new Pair(root, 1));
        
        if (root == null) return;

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // this is part of pre
            // increment 1 to 2 
            // push the left side of the tree
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // this is a part of in 
            // increment 2 to 3 
            // push right 
            else if (it.num == 2) { in .add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // don't push it back again 
            else {
                post.add(it.node.val);
            }
        }
 

    }
    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List < Integer > pre = new ArrayList < > ();
        List < Integer > in = new ArrayList < > ();
        List < Integer > post = new ArrayList < > ();
        allTraversal(root, pre, in , post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }
}
// Output:

// The preorder Traversal is :
// 1 2 4 5 3 6 7
// The inorder Traversal is :
// 4 2 5 1 6 3 7
// The postorder Traversal is :
// 4 5 2 6 7 3 1

// Time Complexity: O(N)

// Reason: We are visiting every node thrice therefore time complexity will be O(3*N), which can be assumed as linear time complexity.

// Space Complexity: O(N)

// Reason: We are using three lists and a stack to store the nodes. The time complexity will be about O(4*N), which can be assumed as linear time complexity.