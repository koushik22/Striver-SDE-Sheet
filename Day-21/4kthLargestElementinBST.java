// The idea is to traverse the BST in an reverse inorder fashion since the reverse inorder traversal visits the nodes of a BST in the descending sorted order. Maintain a counter along with recursion that keeps track of the visited nodes, and when that counter reaches k, return that node. As in java everything is pass by value, instead of passing a variable we need to pass an 2-sized array(where arr[0]->to count the number of nodes we have visited, arr[1]->to store the answer).


public int kthLargest(Node root,int K)
    {
        //Your code here
        int[] nums = new int[2];
        inorder(root , K , nums);
        return nums[1];
    }
    public void inorder(Node root , int k , int[] nums){
        if(root == null)return;
        inorder(root.right , k , nums);
        ++nums[0];
        if(nums[0] == k){
            nums[1] = root.data;
            return;
        }
        inorder(root.left , k , nums);
    }