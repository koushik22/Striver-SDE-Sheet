// Problem Statement: Given below is a binary tree. The task is to print the top view of the binary tree. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

// Solution:

// Intuition:  We can mark straight lines and mark them with +ve and -ve indexes. The first node of every line will be my top view. For example for root node we can mark this as line 0, now if we go to the left child of root, we can mark this node with line -1, and if we go to the right child of root we can marks this node with line +1

// Approach: 

// 1. First we have to make a queue of pair which have nodes and their respective +ve and -ve indexes.
// 2. Then we need a map data structure to store the lines and the nodes. This map will store the data in the form of sorted orders of keys(Lines).
// 3. Here we will follow the level order traversal.
// 4. Traverse through the nodes starting with root,0 and store them to the queue.
// 5. Until the queue is not empty, store the node  and line no. in 2 separate variable .
// 6. Then check if that line is present in the map or not
// 7. If not present then store the line and the node->val to the map
// 8. Otherwise store the node->left and node->right along with there line nos. to the queue.
// 9. Then print the node->val from the map


class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Pair{
        Node node = null;
        int hd = 0;
        
        Pair(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Pair> que = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        que.add(new Pair(root , 0));
        while(que.size() > 0){
            Pair rp = que.remove();
            if(!map.containsKey(rp.hd)){
                map.put(rp.hd , rp.node.data);
            }
            
            if(rp.node.left != null){
                que.add(new Pair(rp.node.left , rp.hd - 1));
            }
            if(rp.node.right != null){
                que.add(new Pair(rp.node.right , rp.hd + 1));
            }
            
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}