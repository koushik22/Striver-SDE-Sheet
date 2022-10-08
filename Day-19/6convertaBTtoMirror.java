The idea is simple – traverse the tree in a postorder fashion, and for every node, swap its left and right child pointer after recursively converting its left and right subtree to mirror first. Following Java implementation of the idea:


class Solution
{
    //Function to convert a binary tree into its mirror tree.
    void mirror(Node node){
        if(node == null)return;
	    mirror(node.left);
	    mirror(node.right);
	    Node temp = node.left;
	    node.left = node.right;
	    node.right = temp;
    }
}

