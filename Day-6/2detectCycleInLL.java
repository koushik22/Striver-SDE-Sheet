/*
Solution 1: Hashing Approach:

Traverse the list one by one and keep putting the node addresses in a Hash Table. At any point, if NULL is reached then return false, and if the next of the current nodes points to any of the previously stored nodes in  Hash then return true.
 */

 /*Complexity Analysis:  

Time complexity: O(n). 
Only one traversal of the loop is needed.
Auxiliary Space: O(n). 
n is the space required to store the value in hashmap.
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)return false;
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while(curr != null){
            if(set.contains(curr)){
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }
    
}

// Solution 2 - Floyd Cycle detection using slow and fast pointer

// Intution

/*

    The purpose is to determine whether the linked list has a cycle or not. First, you keep two pointers of the head node. At each iteration, you move one of the pointers by two steps and the other one by one step. So you have two pointers tortoise and the hare. Eventually one of the two cases will happen:

    Hare will reach the tail of the linked list(null), which means that there is no cycle in it
    Hare will meet tortoise, which means that there is a cycle
    Time complexity is O(N) where N is the number of nodes in the linked list, space complexity is O(1) as you use only two pointers.
    
    Intuition Reference: https://www.codingninjas.com/blog/2020/09/09/floyds-cycle-detection-algorithm/
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}