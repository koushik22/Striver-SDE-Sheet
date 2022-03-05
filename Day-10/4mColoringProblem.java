// Problem Statement: Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with the same color.

// Solution 1: Backtracking

// Approach:

// Basically starting from vertex 0 color one by one the different vertices. 

// Base condition:

// If I have colored all the N nodes return true.

// Recursion:

// Trying every color from 1 to m with the help of a for a loop.

// Is safe function returns true if it is possible to color it with that color i.e none of the adjacent nodes have the same color.

// In case this is an algorithm and follows a certain intuition, please mention it. 

// Color it with color i then call the recursive function for the next node if it returns true we will return true.

// And If it is false then take off the color.

// Now if we have tried out every color from 1 to m and it was not possible to color it with any of the m colors then return false.

import java.util.*;
class TUF {
    public static boolean graphColoring(List < Integer > [] G, int[] color, int i, int C) {
        // Your code here
        int n = G.length;
        if (solve(i, G, color, n, C) == true) return true;
        return false;
    }
    private static boolean isSafe(int node, List < Integer > [] G, int[] color, int n, int col) {
        for (int it: G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }
    private static boolean solve(int node, List < Integer > [] G, int[] color, int n, int m) {
        if (node == n) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m) == true) return true;
                color[node] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int N = 4, M = 3;
        List < Integer > [] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList < > ();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        boolean ans = graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}

// Time Complexity: O( N^M) (n raised to m)

// Space Complexity: O(N)