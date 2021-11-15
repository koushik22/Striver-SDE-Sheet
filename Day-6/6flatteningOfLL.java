/*
In-place
The idea is to merge the linked list in place and merge it recursively with the current flattened list. Basically, we are traversing through the linked list and each time, we are merging the two-child lists into one. We will repeat this process until we are left with only one final linked list containing all the nodes. In short, we repeatedly merge the current list with the already flattened list.

 

Make a function mergeLists which will take two lists as parameters.
Basically, this function is merging two sorted lists as we do in merge sort of linked list.
Inside this function check for the null nodes i.e. if the first list is empty then return the second list else return the first list.
Now compare the data of both the list if the data of first st list is lesser than second then recurse on the child of first
Else recurse on the child of the second list.
Finally, return the node.
Now in the flattenLinkedList function here also recurse on the next pointer of the list and after that call the 'mergeList' functions (to merge the current flattened linked list with already flattened one) and finally return head.
 */

 /*
    Time Complexity: O(N * K)
    Space complexity: O(N)

    Where 'N' denotes the size of the linked list and 'K' is the average number of child nodes for each of the N nodes. 
*/
public class Solution {
	public static Node merge(Node first, Node second) {
		// If the first is null return second
		if (first == null) {
			return second;
		}

		// If the second is null return first
		if (second == null) {
			return first;
		}

		Node merged;

		if (first.data < second.data) {
			merged = first;
			merged.down = merge(first.down, second);
		} else {
			merged = second;
			merged.down = merge(first, second.down);
		}
		return merged;
	}

	public static Node flattenLinkedList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		// Recur on next node
		head.next = flattenLinkedList(head.next);

		// Merge with the current
		head = merge(head, head.next);

		return head;
	}
}

