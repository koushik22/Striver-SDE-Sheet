// Sliding Window Maximum
// Problem Statement: Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.


// Solution 1(Brute Force):

// Intuition: We want to look for a window of size k at a time and then shift to the next window. So why not do exactly what we are asked to! We fix our window of size k at first and then calculate the maximum element in it. We then shift our window to the next position and do the same process until we exhaust all possibilities i.e we reach the end of the array.

// Approach: We initially keep a left and right pointer to fix our window to a size of k. We compute the maximum element present in this window using the GetMax function. Further, update the left and right pointer by left++ and right++ every time to get to a new window of size k using a while loop. For every new window we encounter, we add the maximum element using the GetMax function to our data structure.

// Code:

import java.util.*;
class TUF {
    static void GetMax(int arr[], int l, int r, ArrayList < Integer > maxx) {
        int i, maxi = Integer.MIN_VALUE;
        for (i = l; i <= r; i++)
            maxi = Math.max(maxi, arr[i]);
        maxx.add(maxi);
    }
    static ArrayList < Integer > maxSlidingWindow(int arr[], int k) {
        int left = 0, right = 0;
        int i, j;
        ArrayList < Integer > maxx = new ArrayList < > ();
        while (right < k - 1) {
            right++;
        }
        while (right < arr.length) {
            GetMax(arr, left, right, maxx);
            left++;
            right++;
        }
        return maxx;
    }
    public static void main(String args[]) {
        int i, j, n, k = 3, x;
        int arr[]={4,0,-1,3,5,3,6,8};
        ArrayList < Integer > ans;
        ans = maxSlidingWindow(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + "  ");

    }
}
// Output:

// Maximum element in every 3 window
// 4 3 5 5 6 8

// Time Complexity: O(N^2)

// Reason: One loop for traversing and another to findMax

// Space Complexity: O(K) 

// Reason: No.of windows

// Intuition : Can we do something better?
// To understand this, we would first need to check whether we are doing any repetitions. To understand this, consider the following scenario:

// Window : [1,2,3]  and the next incoming value is 2

// For this state, we get a maximum of 3. However, when our state changes to, [2,3,2] we again check what is the largest element even though we know that the outgoing element is not the largest one. Hence, the point of concern lies only when the outgoing element was the largest. 

// Approach
// We address this problem with the help of a data structure that keeps checking whether the incoming element is larger than the already present elements. This could be implemented with the help of a de-queue. When shifting our window, we push the new element in from the rear of our de-queue.

// Every time before entering a new element, we first need to check whether the element present at the front is out of bounds of our present window size. If so, we need to pop that out. Also, we need to check from the rear that the element present is smaller than the incoming element. If yes, there’s no point storing them and hence we pop them out. Finally, the element present at the front would be our largest element.

// Code:

import java.util.*;
class TUF {
    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
    public static void main(String args[]) {
        int i, j, n, k = 3, x;
        int arr[]={4,0,-1,3,5,3,6,8};
        int ans[] = maxSlidingWindow(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");

    }
}
// Output:

// Maximum element in every 3 window
// 4 3 5 5 6 8

// Time Complexity: O(N)

// Space Complexity: O(K)

