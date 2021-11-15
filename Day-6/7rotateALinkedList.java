// Naive Approach

/*
Pick up the last node and put it on the front. Then again pick up the last node and put it on the front and do it for 
k times. After that you'll get your resultant LL.
 */
// TC - O(n*k), to find the last node we need O(n) time and we need to find the last node k times, so the complexity is O(n*k).



// Optimal Approach by making the LL as circular LL.
/*
EXPLANATION

Let's take the following list as an example:

Node 1 -> Node 2 -> Node 3 -> Node 4 -> Node 5
with K = 3

Make the list circular first and calculate the length of the actual linear list:

Node 1 -> Node 2 -> Node 3 -> Node 4 -> Node 5 -> Node 1

Length = 5

Now, our result after K = 3 rotations should look like this:

Node 3 -> Node 4 -> Node 5 -> Node 1 -> Node 2

That is, we need to break the link between Node 2 and Node 3, in the circular linked list, which is at position length - K (5 - 3 = 2) from the start (head) of the list.

So start traversing until cut = length - K from the start. After the traversal ends, make Node 3 the head of the linked list and make the next node of curr (here Node 2) equal to null.

Note: K can be greater than the length of the list so use the modulo (%) operation before starting the rotation.

Edge Cases: (Length of list is 0 or 1) and (K is 0 or a multiple of the length of the list). In either case, return head.
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // edge cases 
        if (head == null || head.next == null|| k == 0) return head;
        
        // compute the length
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            len++; 
            cur = cur.next;
        } 
            
        
        // go till that node
        cur.next = head;
        k = k % len;
        k = len - k;
        while (k-- > 0) cur = cur.next;
        
        // make the node head and break connection 
        head = cur.next;
        cur.next = null;
        
        
        return head; 
    }
}

// TC - O(n) + O(n - k) ~ O(n) , SC - O(1)