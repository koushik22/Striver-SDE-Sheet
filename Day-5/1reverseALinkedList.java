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
 /*
 Iterative Solution

 We will use three-pointers to traverse through the entire list and interchange links between nodes. One pointer to keep track of the current node in the list. The second one is to keep track of the previous node to the current node and change links. Lastly, a pointer to keep track of nodes in front of current nodes.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
      ListNode curr = head;
      ListNode prev = null;
      ListNode ocn;
      while(curr != null){
          ocn = curr.next;
          curr.next = prev;
          prev = curr;
          curr = ocn;
          
      }
      return prev;
    }
}

/*
Time Complexity:

Since we are iterating only once through the list and achieving reversed list. Thus, the time complexity is O(N) where N is the number of nodes present in the list.

Space Complexity:

To perform given tasks, no external spaces are used except three-pointers. So, space complexity is O(1).
 */



/*
Solution 2: Using Recursion

We traverse to the end of the list recursively.

As we reach the end of the list, we make the end node the head. Then receive previous nodes and make them connected to the last one.

At last, we link the second node to the head and the first node to NULL. We return to our new head.
 */

 class Solution {

    public ListNode reverseList(ListNode head) {

        if (head == null||head.next==null)
            return head;

        ListNode nhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nhead;
    }
}
/*
Time Complexity:

We move to the end of the list and achieve our reversed list. Thus, the time complexity is O(N) where N represents the number of nodes.

Space Complexity:

Apart from recursion using stack space, no external storage is used. Thus, space complexity is O(1).
 */