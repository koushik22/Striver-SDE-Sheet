/*
Solution 1: Naive Approach

Intuition: We can traverse through the Linked List while maintaining a count of nodes let’s say in variable n , and then traversing for 2nd time for n/2 nodes to get to the middle of the list.
*/
Code:

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
    public ListNode middleNode(ListNode head) {
    	int n = 0;
    	ListNode temp = head;
    	while(temp) {
        	n++;
        	temp = temp.next;
    	}
   	 
    	temp = head;
   	 
    	for(int i = 0; i < n / 2; i++) {
        		temp = temp.next;
    	}
   	 
    	return temp;
	}
};

/*
Solution 2: [Efficient] Tortoise-Hare-Approach

Unlike the above approach, we don’t have to maintain nodes count here and we will be able to find the middle node in a single traversal so this approach is more efficient.

Intuition: In the Tortoise-Hare approach, we increment slow ptr by 1 and fast ptr by 2, so if take a close look fast ptr will travel double than that of the slow pointer. So when the fast ptr will be at the end of Linked List, slow ptr would have covered half of Linked List till then. So slow ptr will be pointing towards the middle of Linked List.

Approach: 

Create two pointers slow and fast and initialize them to a head pointer.
Move slow ptr by one step and simultaneously fast ptr by two steps until fast ptr is NULL or next of fast ptr is NULL.
When the above condition is met, we can see that the slow ptr is pointing towards the middle of Linked List and hence we can return the slow pointer.

*/
Code:

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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
/*
Time Complexity: O(N)
Space Complexity: O(1)
*/