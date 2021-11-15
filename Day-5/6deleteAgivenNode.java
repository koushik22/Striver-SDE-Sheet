public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}

// Since we couldn't enter the preceding node, we can not delete the given node. We can just copy the next node to the given node and delete the next one.