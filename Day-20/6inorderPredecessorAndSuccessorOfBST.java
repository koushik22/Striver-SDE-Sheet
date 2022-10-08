// INORDER TRAVERSAL
// 1. The fact that all the data values are unique makes the solution look very intuitive.
// 2. We can simply store the inorder traversal of the given tree in the array, and find the element present before and after the given node in the array.
//   a. For every node, its left subtree is visited recursively, and then the node itself is visited(the data is stored in the array), and then its right subtree.
// After the traversal, we can find the given node in the inorder array and return its predecessor and successor, if any.

// Time Complexity
// O(N),  where ‘N’ is the number of nodes in the BST.

 

// As we are traversing each node of the BST once, the time complexity will be linear.

// Space Complexity
// O(N), where ‘N’ is the number of nodes in the BST.

 

// In the worst case (skewed trees), we will have all the nodes of the BST in the recursion stack. 

// Also, the maximum possible size of the array used to store inorder traversal will be equal to N. Hence, the space complexity is linear.


/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    where 'N' is the number of nodes in the BST.
*/

import java.util.ArrayList;

public class Solution {
	public static void inorder(BinaryTreeNode<Integer> root, ArrayList < Integer > inorderArray)
	{
	    if (root == null)
	    {
	        return;
	    }

	    inorder(root.left, inorderArray);

	    inorderArray.add(root.data);

	    inorder(root.right, inorderArray);
	}

	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// To store the inorder traversal of the BST.
	    ArrayList < Integer > inorderArray = new ArrayList < Integer > ();

	    inorder(root, inorderArray);

	    int predecessor = -1, successor = -1;

	    for (int i = 0; i < inorderArray.size(); i++)
	    {
	        if (inorderArray.get(i) == key)
	        {
	            // If predecessor exist.
	            if (i - 1 >= 0)
	            {
	                predecessor = inorderArray.get(i - 1);
	            }

	            // If successor exist.
	            if (i + 1 < inorderArray.size())
	            {
	                successor = inorderArray.get(i + 1);
	            }
	            break;
	        }
	    }
		
        ArrayList < Integer > sol = new ArrayList < Integer > ();
        sol.add(predecessor);
        sol.add(successor);
	    return sol;
	}
}



// OPTIMIZED APPROACH
// A node’s predecessor in a BST is the greatest value present in its left subtree. If the left subtree doesn’t exist, then the predecessor can be one of his ancestors.

// Similarly, a node’s successor in a BST is the smallest value present in its right subtree. If the right subtree doesn’t exist, then the successor can be one of his ancestors.

// Here is the algorithm:

// 1. We will run a loop until we reach the node given to us.
//     i. If the value of the current node is smaller than the given node, we will set the predecessor as the current node and move to its right child.

//     ii. Else, we will set the successor as the current node and move to its left child.

// 2. After we reach the given node, we find the maximum value of the left subtree and the minimum value of the right subtree. Then set the values of predecessor and successor, accordingly.

// Time Complexity
// O(N),  where ‘N’ is the number of nodes in the BST.

 

// In the worst case(skewed tree), we will have to traverse all the nodes in the BST. Hence the time complexity will be O(N).

// Space Complexity
// O(1), i.e. we are using constant space.

 

// We are not using any extra space. Hence, the space complexity is constant.



/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    where 'N' is the number of nodes in the BST.
*/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		int predecessor = -1;
	    int successor = -1;

	    // Reach to the key.
	    while (root.data != key)
	    {
	        if (key > root.data)
	        {
	            predecessor = root.data;
	            root = root.right;
	        }
	        else
	        {
	            successor = root.data;
	            root = root.left;
	        }
	    }

	    
	    BinaryTreeNode < Integer > rightSubtree = root.right;

	    while (rightSubtree != null)
	    {
	        successor = rightSubtree.data;
	        rightSubtree = rightSubtree.left;
	    }


	    BinaryTreeNode < Integer > leftSubtree = root.left;

	    while (leftSubtree != null)
	    {
	        predecessor = leftSubtree.data;
	        leftSubtree = leftSubtree.right;
	    }

	    ArrayList < Integer > sol = new ArrayList < Integer > ();
        sol.add(predecessor);
        sol.add(successor);
	    return sol;
	}
}