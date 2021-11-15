/*
Method 1(Simply use two loops) 
Use 2 nested for loops. The outer loop will be for each node of the 1st list and inner loop will be for 2nd list. In the inner loop, check if any of nodes of the 2nd list is same as the current node of the first linked list. The time complexity of this method will be O(M * N) where m and n are the numbers of nodes in two lists.
 */

 /*
 Method 2(Using Hashing)
 The idea is to traverse the first list and store each node’s address in a HashTable. Then traverse the second list and get the address of the first node present in the hash table. This node would be the intersection point.
 */

 import java.util.HashSet;
import java.util.Set;
 
// A Linked List Node
class Node
{
    int data;
    Node next;
}
 
class Main
{
    // Utility function to create a new node with the given data and
    // pushes it onto the list's front
    public static Node push(Node head, int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = head;
        return node;
    }
 
    // Function to find the intersection point of two linked lists using hashing
    public static Node findIntersection(Node first, Node second)
    {
        // maintain a set to store list nodes
        Set<Node> nodes = new HashSet<>();
 
        // traverse the first list and insert the address of each node into the set
        while (first != null)
        {
            nodes.add(first);
            first = first.next;
        }
 
        // now traverse the second list and find the first node that is
        // already present in the set
        while (second != null)
        {
            // return the current node if it is found in the set
            if (nodes.contains(second)) {
                return second;
            }
            second = second.next;
        }
 
        // we reach here if lists do not intersect
        return null;
    }
 
    public static void main(String[] args)
    {
        // construct the first linked list (1 —> 2 —> 3 —> 4 —> 5 —> null)
        Node first = null;
        for (int i = 5; i > 0; i--) {
            first = push(first, i);
        }
 
        // construct the second linked list (1 —> 2 —> 3 —> null)
        Node second = null;
        for (int i = 3; i > 0; i--) {
            second = push(second, i);
        }
 
        // link tail of the second list to the fourth node of the first list
        second.next.next.next = first.next.next.next;
 
        Node addr = findIntersection(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }
    }
}
/*
The time complexity of the above solution is O(m+n). Where m and n are the total number of nodes in the first and second list, respectively. However, the program uses additional space for storing nodes of the first list in a hash table.
 */

 /*
 Method 3 - Optimal(Use differences in nodes count)

 We can also use the difference in node counts of both lists to find the intersection point. The idea is to advance the bigger list by k nodes, where k is the difference in the number of nodes in both lists. Then move both lists at the same speed until they intersect with each other. The node at which both lists intersect is the intersection point.
  */

  // A Linked List Node
class Node
{
    int data;
    Node next;
}
 
class Main
{
    // Utility function to create a new node with the given data and
    // pushes it onto the list's front
    public static Node push(Node head, int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = head;
        return node;
    }
 
    // Utility function to find the total number of nodes in a linked list
    public static int size(Node head)
    {
        int nodes = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            nodes++;
        }
        return nodes;
    }
 
    // Function to find the intersection point of two linked lists.
    // Assume that the first list contains `k` nodes more than the second list
    public static Node findIntersection(Node first, Node second, int k)
    {
        // advance the bigger list by `k` nodes
        for (int i = 0; i < k && first!= null; i++) {
            first = first.next;
        }
 
        // simultaneously move both lists at the same speed until they meet
        while (first != null && second != null)
        {
            // if both lists meet any node, then that node is the intersection point
            if (first == second) {
                return first;
            }
 
            // advance both lists by one node
            first = first.next;
            second = second.next;
        }
 
        // return null if both lists don't meet
        return null;
    }
 
    // Function to find the intersection point of two linked lists
    public static Node findIntersection(Node first, Node second)
    {
        // get the difference in the number of nodes in both lists
        int diff = size(first) - size(second);
 
        // if the first list has a smaller number of nodes, exchange both lists
        if (diff < 0)
        {
            Node node = first;
            first = second;
            second = node;
        }
 
        // find and return the intersection node
        return findIntersection(first, second, Math.abs(diff));
    }
 
 
    public static void main(String[] args)
    {
        // construct the first linked list (1 —> 2 —> 3 —> 4 —> 5 —> null)
        Node first = null;
        for (int i = 7; i > 0; i--) {
            first = push(first, i);
        }
 
        // construct the second linked list (1 —> 2 —> 3 —> null)
        Node second = null;
        for (int i = 3; i > 0; i--) {
            second = push(second, i);
        }
 
        // link tail of the second list to the fourth node of the first list
        second.next.next.next = first.next.next.next;
 
        Node addr = findIntersection(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }
    }
}

/*
The time complexity of the above solution is O(m+n), where m and n are the total number of nodes in the first and second list, respectively.
 */

// Method 4 - Optimal(Using distance from intersection point)
/*
Observation: The total number of nodes in the first list + distance of the head of the second list from the intersection point = The total number of nodes in the second list + distance of the head of the first list from the intersection point.

The idea is to take two pointers, x and y, initially pointing to the head of the first and second lists. Then advance both pointers at the same pace until they meet at a common node. When x reaches its end, redirect it to the head of the second list. When y reaches its end, turn it to the head of the first list. The node where x meets y is the intersection node.
 */

 // A Linked List Node
class Node
{
    int data;
    Node next;
}
 
class Main
{
    // Utility function to create a new node with the given data and
    // pushes it onto the list's front
    public static Node push(Node head, int data)
    {
        // create a new linked list node from the heap
        Node node = new Node();
        node.data = data;
        node.next = head;
 
        return node;
    }
 
    // Function to find the intersection point of two linked lists
    public static Node findIntersection(Node first, Node second)
    {
        // Take two pointers pointing to the heads of respective lists
        Node x = first, y = second;
 
        // advance both pointers until they meet at a common node
        while (x != y)
        {
            // When the first list reaches its end, redirect it to the
            // head of the second list
            if (x == null) {
                x = second;
            }
            else {
                x = x.next;
            }
 
            // When the second list reaches its end, redirect it to the
            // head of the first list
            if (y == null) {
                y = first;
            }
            else {
                y = y.next;
            }
        }
 
        // return the common node
        return x;
    }
 
    public static void main(String[] args)
    {
        // construct the first linked list (1 —> 2 —> 3 —> 4 —> 5 —> null)
        Node first = null;
        for (int i = 7; i > 0; i--) {
            first = push(first, i);
        }
 
        // construct the second linked list (1 —> 2 —> 3 —> null)
        Node second = null;
        for (int i = 3; i > 0; i--) {
            second = push(second, i);
        }
 
        // link tail of the second list to the fourth node of the first list
        second.next.next.next = first.next.next.next;
 
        Node addr = findIntersection(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }
    }
}

/*
The time complexity of the above solution is O(m+n), where m and n are the total number of nodes in the first and second list, respectively.
 */