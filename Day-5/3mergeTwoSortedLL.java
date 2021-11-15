// Recursive Solution

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)return l1 == null ? l2 : l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}

/*
Solution 1: Using an externally linked list to store answers.

Approach :

Step 1: Create a new dummy node. It will have the value 0 and will point to NULL respectively. This will be the head of the new list. Another pointer to keep track of traversals in the new list.

Step 2:  Find the smallest among two nodes pointed by the head pointer of both input lists. Store that data in a new list created.

Step 3: Move the head pointer to the next node of the list whose value is stored in the new list.

Step 4: Repeat the above steps till any one of the head pointers stores NULL. Copy remaining nodes of the list whose head is not NULL in the new list.
 */
 class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2  == null)return l1 == null ? l2 : l1;
        
        ListNode dummy = new ListNode(0);
        ListNode c3 = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        
        while(c1 != null && c2 != null){
            if(c1.val <= c2.val){
                c3.next = c1;
                c3 = c3.next;
                c1 = c1.next;
            }
            else{
                c3.next = c2;
                c3 = c3.next;
                c2 = c2.next;
            }
        }
        
         while(c1 != null){
                c3.next = c1;
                c3 = c3.next;
                c1 = c1.next;
         }
        
        while(c2 != null){
                c3.next = c2;
                c3 = c3.next;
                c2 = c2.next;
         }
        
        return dummy.next;
    }
}

 /*
 dummy->next will result in the head of the new list.

Time Complexity: O(N+M).

Let N be the number of nodes in list l1 and M be the number of nodes in list l2. We have to iterate through both lists. So, the total time complexity is O(N+M).

Space Complexity: O(N+M).

We are creating another linked list that contains the (N+M) number of nodes in the list. So, space complexity is O(N+M).
 
*/

