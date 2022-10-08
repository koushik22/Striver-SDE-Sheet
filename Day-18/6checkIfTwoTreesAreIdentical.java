// Problem Statement: Given two Binary Tree. Write a program to check if two trees are identical or not.


// Solution:
// Approach: In order to check whether two trees are identical or not, we need to traverse the trees. While traversing we first check the value of the nodes, if they are unequal we can simply return false, as trees are non-identical. If they are the same, then we need to recursively check their left child as well as the right child. When we get all the three values as true(node values, left child, right child) we can conclude that these are identical trees and can return true. Any other combination will return false.

public class Solution {
    static boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;

        return ((node1.data == node2.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right));
    }


// Time Complexity: O(N).

// Reason: We are doing a tree traversal.

// Space Complexity: O(N)

// Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).