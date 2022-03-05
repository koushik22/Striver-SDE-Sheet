// Monotonic Stack
// 1. We will follow some reverse strategy for building our final solution instead of finding minimums for every possible window. We will find how many windows our current element can be the answer.

// 2. To find that we will calculate the indexes of the next smaller and previous smaller element for every element given in the array. The next smaller element is some number that is smaller than the current element and lies nearest on the right-hand side of the current element. Similarly, the previous smaller is some number that is smaller than the current element and lies nearest on the left-hand side of the current element.

// 3. If there is no next smaller element for the current number then we will assume its index having value N and if there is no previous smaller element for the current number then we will assume its index having value -1.

// 4. The above two arrays of the next smaller and previous smaller can be done in linear time with the help of Monotonic Stack.
// Suppose ‘next[i]’ = index of next smaller element, ‘prev[i]’ = index of previous smaller element. Now, we know the ‘ARR[i]’ will be the minimum of the window of size -> size = next[i] - prev[i] + 1. So, we will directly use the value of ‘ARR[i]’ for updating the answer of window having size = next[i] - prev[i] + 1.

// 5. After doing this for every element we can update our answer for windows of some different lengths i.e, we are still left with some window sizes for which the answer is not calculated yet. So to fill the remaining entries we will use some observations listed below:-

//     i. The answer for some window having size ‘L’ would always be greater than or equal to the answer for a window having a length greater than L i.e, L+1, L+2 .... so on.
//     ii. Hence, we will update the remaining uncalculated answer for some windows having length ‘L’ with the maximum suffix starting from length ‘L+1’.

// Time Complexity
// O(N), where ‘N’ is the number of elements present in the array.

 

// The Time Complexity for creating the next array and the prev array from Monotonic Stack takes linear time. For each element, we update our answer using next and prev in constant time. Hence, the overall Time Complexity is O(N).

// Space Complexity
// O(N), where ‘N’ is the number of elements present in the array.

 

// We are using two extra arrays, next and prev of size N. Hence, the overall Space Complexity is O(N).

/*
    Time Complexity: O(N)
	Space complexity: O(N)

	Where 'N' is the number elements present in the given array.
 */

import java.util.Stack;

public class Solution 
{
    public static int[] maxMinWindow(int[] arr, int n) 
    {
        // Definition: answer[i] will store the maximum of minimum of every window of size 'i'.
        int[] answer = new int[n];
        
        for (int i = 0; i < n; ++i) 
        {
            answer[i] = Integer.MIN_VALUE;
        }

        // Definition: next[i] will store the index of next smaller element which lie on the right hand side of 'i'.
        int[] next = nextSmaller(arr, n);

        // Definition: prev[i] will store the index of previous smaller element which lie on the left hand side of 'i'.
        int[] prev = previousSmaller(arr, n);

        for (int i = 0; i < n; i++) 
        {
            // Length of the window in which a[i] is minimum
            int length = next[i] - prev[i] - 1;
            
            // Update the answer[length-1] ( 0 based indexing )  with a[i]
            answer[length - 1] = Math.max(answer[length - 1], arr[i]);
        }
        
       // Some entries in answer[] may not be filled yet.
       // We fill them by taking maximum element from suffix starting from 'i'.
        for (int i = n - 2; i >= 0; i--) 
        {
            answer[i] = Math.max(answer[i], answer[i + 1]);
        }

        return answer;
    }

	// This function will return an array.
    // Each ith position contains the index of previous smaller elements in the original array.
    private static int[] previousSmaller(int[] arr, int n) 
    {
        int[] prev = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < n; i++) 
        {
            while (!s.empty() && arr[s.peek()] >= arr[i]) 
            {
                s.pop();
            }
            
            if (s.empty()) 
            {
                prev[i] = -1;
            } 
            else 
            {
                prev[i] = s.peek();
            }
            
            s.push(i);
        }
        
        return prev;
    }

    // This function will return an array.
    // Each ith position contains the index of next smaller elements in the original array.
    private static int[] nextSmaller(int[] arr, int n) 
    {
        Stack<Integer> s = new Stack<>();
        int[] next = new int[n];
    
        for (int i = n - 1; i >= 0; i--) 
        {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) 
            {
                s.pop();
            }
            
            if (s.empty()) 
            {
                next[i] = n;
            } 
            else 
            {
                next[i] = s.peek();
            }
            
            s.push(i);
        }
        
        return next;
    }

}

