// Problem Statement: Given the root of a binary tree, return the zigzag level order traversal of Binary Tree. (i.e., from left to right, then right to left for the next level and alternate between).

// Intuition: Considering the fact that we need to print the nodes, level by level, our first guess would definitely be that it must be related to level order traversal. If we closely examine, for even levels we need to go from left to right while for odd levels we need to go from right to left. 

// Approach: The above idea, could be implemented with a queue. We initially keep an empty queue and push the root node. We also need to keep the bool variable zigzag that keeps check of the current level we are in. As we traverse nodes in the queue, we need to push them in a temporary list. If zigzag is true we need to push the elements in front of our list data structure so it will be a reversed list in the end or else, simply push it in our data structure. In the end, when we have finished traversing the current level, we need to toggle our zigzag variable.


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        boolean zigzag = false;
        while(que.size() > 0){
            int size = que.size();
            List<Integer> temp = new LinkedList<>();
            while(size-- > 0){
                TreeNode rn = que.removeFirst();
                if(rn.left != null)que.add(rn.left);
                if(rn.right != null)que.add(rn.right);
                
                if(zigzag){
                    temp.add(0 , rn.val);
                }
                else{
                    temp.add(rn.val);
                }
                
            }
            zigzag = !zigzag;
            res.add(new ArrayList<>(temp));
        }
        return res;   
    }
}

// Time Complexity: O(N)   

// Space Complexity: O(N)