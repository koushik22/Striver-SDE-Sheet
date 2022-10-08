For complete explanation of the code follow this https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/1654181 


// Simple BFS

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node rightNode = null;
            for(int i = q.size(); i > 0; i--) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if(cur.right != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;        
    }
}
// Time Complexity : O(N), where N is the number of nodes in the given tree. We only traverse the tree once using BFS which requires O(N).
// Space Complexity : O(W) = O(N), where W is the width of given tree. This is required to store the nodes in queue. Since the given tree is a perfect binary tree, its width is given as W = (N+1)/2 ≈ O(N)


// Simple DFS

class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        Node leftNode = root;
        
        if(leftNode.left != null){
            Node head = root;
            if(head != null){
                head.left.next = head.right;
                if(head.next != null)head.right.next = head.next.left;
                connect(root.left);
                connect(root.right);
            }
        }
        return root;
    }
}


// Time Complexity : O(N), each node is only traversed once
// Space Complexity : O(logN), required for recursive stack. The maximum depth of recursion is equal to the height of tree which in this case of perfect binary tree is equal to O(logN)



// Optimized BFS using pointers


// This is a combination of logic of above logics- we will traverse in BFS manner but populate the next pointers of bottom level just as we did in the DFS solution.

// Usually standard DFS/BFS takes O(N) space, but since we are given the next pointers in each node, we can use them to space-optimize our traversal to O(1).

// 1. We first populate the next pointers of child nodes of current level. This makes it possible to traverse the next level without using a queue. To populate next pointers of child, the exact same logic as above is used
// 2. We simply traverse to root's left child and repeat the process - traverse current level, fill next pointers of child nodes and then again update root = root -> left. So, we are basically performing standard BFS traversal in O(1) space by using next pointers to our advantage
// 3. The process continues till we reach the last level of tree


class Solution {
    public Node connect(Node root) {
        Node head = root;
        for(; root != null; root = root.left) 
            for(Node cur = root; cur != null; cur = cur.next) 
                if(cur.left != null) {
                    cur.left.next = cur.right;
                    if(cur.next != null) cur.right.next = cur.next.left;
                } else break;
        
        return head;
    }
}
// Time Complexity : O(N), we only traverse each node once, basically doing a standard BFS.
// Space Complexity : O(1), only constant extra space is being used