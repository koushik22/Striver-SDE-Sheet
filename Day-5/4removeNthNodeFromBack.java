/*
Solution 1: Naive Approach [Traverse 2 times]

Intuition: We can traverse through the Linked List while maintaining a count of nodes, let’s say in variable count , and then traversing for the 2nd time for (n – count) nodes to get to the nth node of the list.
*/

/*
Solution 2: [Efficient] Two pointer method

Unlike the above approach, we don’t have to maintain the count value, we can find the nth node just by one traversal by using two pointer approach.

Intuition : 

What if we had to modify the same above approach to work in just one traversal? Let’s see what all information we have here:

We have the flexibility of using two-pointers now.
We know, the n-th node from the end is the same as (total nodes – n)th node from start.
But, we are not allowed to calculate total nodes, as we can do only one traversal.
What if, one out of the two-pointers is at the nth node from start instead of end? Will it make anything easier for us?

Yes, with two pointers in hand out of which one at n-th node from start, we can just advance both of them till end simultaneously, once the faster reaches the end, the slower will stand at the n-th node from the end.

Approach : 

Take two dummy nodes, who’s next will be pointing to the head.
Take another node to store the head, initially it,s a dummy node(start), and the next of the node will be pointing to the head.The reason why we are using this extra dummy node, is because there is an edge case. If the node is equal to the length of the linkedlist, then this slow’s will point to slow’s next→ next. And we can say our dummy start node will be broken, and will be connected to the slow’s next→ next.
Start traversing until the fast pointer reaches the nth node.

Now start traversing by one step both of the pointers until the fast pointers reach the end.    

When the traversal is done, just do the deleting part. Make  slow pointer’s next to the next of next of the slow pointer to ignore/disconnect the given node.

Last, return the next of start.
Dry Run:  We will be taking the first example for the dry run, so, the linkedlist is [1,2,3,4,5] and the node which has to be deleted is 2 from the last. For the first time fast ptr starts traversing from node 1 and reaches to 2, as it traverses for node number 2, then the slow ptr starts increasing one, and as well as the fast ptr, until it reaches the end.

1st traversal : fast=3, slow=1
2nd traversal : fast=4, slow=2
3rd traversal : fast=5, slow=3
Now, the slow->next->next will be pointed to the slow->next

So , the new linked list will be [1,2,3,5]
*/
// Code : 

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;     

        for(int i = 1; i <= n; ++i)
            fast = fast.next;
    
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return start.next;
    }
}

/*
Time Complexity: O(N)

Space Complexity: O(1)
*/