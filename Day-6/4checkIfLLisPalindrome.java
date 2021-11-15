/*
METHOD 1 (Use a Stack) 



A simple solution is to use a stack of list nodes. This mainly involves three steps.
Traverse the given list from head to tail and push every visited node to stack.
Traverse the list again. For every visited node, pop a node from the stack and compare data of popped node with the currently visited node.
If all nodes matched, then return true, else false.
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            st.push(curr.val);
            curr = curr.next;
        }
        
        while(head != null){
            if(head.val != st.pop())return false;
            head = head.next;
        }
        return true;
    }
}

// TC - O(n), SC - O(n)

/*
METHOD 2 (Reversing second half of the LL)
Solution - O(N) : O(1)

We can solve the problem in O(1) space complexity. For this, we can reverse the linked list from start till middle of linked list and then we can simple match each element in the first half and second half to determine if linked list is palindrome.

The middle of linked list can be found using the slow-fast pointer approach.
 */

 class Solution {
    public boolean isPalindrome(ListNode head) {
                if(head==null||head.next==null)
            return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverseList(slow.next);
        slow=slow.next;
        while(slow!=null){
            if(head.val!=slow.val)
                return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
    ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}