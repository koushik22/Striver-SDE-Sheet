// Problem Statement: Given an array of integers heights representing the histogram’s bar height where the width of each bar is 1 , return the area of the largest rectangle in histogram.


// Solution
// Disclaimer: Don’t jump directly to the solution, try it out yourself first.

// Solution 1: Brute Force Approach

// Intuition: The intuition behind the approach is taking different bars and finding the maximum width possible using the bar.

// Approach:

// The approach is to find the right smaller and left smaller element and find the largest Rectangle area in Histogram.

import java.util.*;
// Brute Force Approach to find largest rectangle area in Histogram
public class Main {
    static int largestarea(int arr[], int n) {
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
    public static void main(String args[]) {
        int arr[] = {2, 1, 5, 6, 2, 3, 1};
        int n = 7;
        System.out.println("The largest area in the histogram is " + largestarea(arr, n)); // Printing the largest rectangle area

    }
}
// Output: The largest area in the histogram is 10

// Time Complexity: O(N*N ) 

// Space Complexity: O(1)

// Solution 2: Optimised Approach 1

// Intuition: The intuition behind the approach is the same as finding the smaller element on both sides but in an optimized way using the concept of the next greater element and the next smaller element.

// Approach: 

import java.util.*;
// Brute Force Approach to find largest rectangle area in Histogram
public class Main {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;

    }
    public static void main(String args[]) {
        int arr[] = {2, 1, 5, 6, 2, 3, 1};
        int n = 7;
        System.out.println("The largest area in the histogram is " + 
        largestRectangleArea(arr)); 

    }
}
// Output: The largest area in the histogram is 10

// Time Complexity: O( N )

// Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array

//For complete explanation visit
// https://takeuforward.org/data-structure/area-of-largest-rectangle-in-histogram/