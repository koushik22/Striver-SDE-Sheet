/*
Approach 1
Forget about the random pointers and think that if the question had been to clone a normal singly linked list, what would our approach have been? 

We would then simply traverse the given list, and for each node in the original list, create a new node in the clone and set up the pointers correctly.


Here, also, we will do the same in the first step. i.e., clone the linked list with the next pointers without caring about the random pointers. 

Next, we create a hashmap. The key of the hashmap is an original node, and its corresponding value is the new node that we create while iterating the original list.

In the second iteration over the original list,  we clone the random pointer using this relation – 

cloned_node -> random =  map[original_node -> random]

where map[original_node -> random] is the node in the cloned list corresponding to the node original_node->random in the original list. 
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> mpp = new HashMap<>();
        Node curr = head;
        Node res = new Node(0);
        Node cloneCurr = res
        
        // Use HashMap to store the cloned node with this corresponding node
        while(curr != null){
            Node temp = new Node(curr.val,null,null);
            cloneCurr.next = temp;
            mpp.put(curr,temp);
            cloneCurr = cloneCurr.next;
            curr = curr.next;
        }
        
        // setting up random pointers
        
        curr = head;
        cloneCurr = res.next;
        while(curr != null){
            cloneCurr.random = mpp.get(curr.random);
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }
        return res.next;
    }
}

/*
Time Complexity

The time complexity of this method is O(n), where n is the number of nodes in the given linked list. Since we traverse the original linked list 2 times to construct the cloned list. Total complexity is  O(n)+O(n) = O(2*n), which is ultimately O(n). 

Space Complexity

We are using a hashmap to map the old list nodes to the new list nodes. Since extra space used is equal to the number of nodes in the list, the space complexity becomes O(n), where n is the number of nodes in the linked list.
 */





/*
Approach 2 (clone a linked list with next and random pointer in O(1) space)
In the previous approach, we used a hash map which resulted in a space complexity of O(n). 

In this approach, we will proceed in the following steps to reduce the space complexity – 

Step - 1:
Create a copy of Node1 and insert it between Node1 and Node2 in the original linked list itself. Similarly, create a copy of Node 2 and insert it between Node 2 and Node 3 in the original linked list. Repeat this process for all the nodes. 
In general, insert a copy of the Node-i between Node_i and Node_i+1. For the last node, insert its copy after it. 

Now, for all the nodes of the original list –

original->next = cloned_node

Step - 2:
 In this step, we will set the random pointers of each cloned node in this way – 
(original->next)->random = (original->random)->next

because original->next is nothing but a copy of the original node and (original->random)->next is nothing but a copy of random.

Step - 3

Now, restore the original linked list and clone of the linked list in a single traversal in the following way – 
original->next = original->next->next

copy->next = copy->next->next


So, The first list is the original list and the second one is the clone of the linked list which we just constructed.

 */

 /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
          Node iter = head; 
          Node front = head;

          // First round: make copy of each node,
          // and link them together side-by-side in a single list.
          while (iter != null) {
            front = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;

            iter = front;
          }

          // Second round: assign random pointers for the copy nodes.
          iter = head;
          while (iter != null) {
            if (iter.random != null) {
              iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
          }

          // Third round: restore the original list, and extract the copy list.
          iter = head;
          Node pseudoHead = new Node(0);
          Node copy = pseudoHead;

          while (iter != null) {
            front = iter.next.next;

            // extract the copy
            copy.next = iter.next;
            copy = copy.next;

            // restore the original list
            iter.next = front;

            iter = front;
          }

          return pseudoHead.next;
    }
}

/*
Time Complexity

It is O(n) because in total we make three passes over the entire linked list. The first time, to insert a copy of the original nodes after each of them. The second time, to set up the random pointer of the copy nodes correctly. The third time, to separate the original linked list and clone of the linked list. So, total operations are O(3*n) ⋍ O(n), which is linear complexity.

Space Complexity

It is O(1). Since we don’t use any extra data structure in our algorithm apart from just some variables, it needs only constant space. 
 */