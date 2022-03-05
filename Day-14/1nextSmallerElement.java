// Brute Force Approach
// The idea is to find the Next Smaller Element for each array element one by one. To find the Next Smaller for an array element we will start moving to the right of that element and will try to find the first element having a value smaller than that element and set the Next Smaller Element as that element and end our search. If we reach the end of the array without finding any such element then we will set the next smaller element as -1 for that element.

// Let ans be an array of length N that stores the Next Smaller Elements.

 

// Steps :

// 1. Set all values of array ans as -1.
// 2. Iterate from i = 0 to N - 1
// 3. Iterate from j = i + 1 to N -1 
// 4. If ARR [i] is greater than ARR [j]then set the value of ans [i] to ARR [j] and break the loop.
// 5. Return the array ans .

// Time Complexity
// O(N ^ 2), where ‘N’ is the number of elements in the array.

 

// We are traversing the array. And for each element we are checking all the elements to the right of it. Thus, at most ‘N’ searches for each index. Hence, the total time complexity is O(N^2).

// Space Complexity
// O(1), as we are using constant extra space.

/*
    Time Complexity: O(N ^ 2)
    Space Complexity: O(1)

    where N denotes the number of elements in the array.
*/

import java.util.ArrayList;

public class Solution{
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

         // Iterating through all the array elements and finding next smaller element for each element.
   		 for (int i = 0; i < n; i++) {

       	 	// Initializing the next smaller element as -1.
        	ans.add(-1);

        	// Moving to the right of the element.
        	for (int j = i + 1; j < n; j++) {

            	// Checking for the next smaller element.
            	if (arr.get(i) > arr.get(j)) {
					ans.set(i, arr.get(j));
                	break;
            	}
        	}	
    	}

        return ans;
    }
}


// Optimized Approach using Stack
// The idea is to find the Next Smaller Element for each of the N array elements in one iteration of the array by using a stack. Our approach is to traverse the array from right to left and for each array element we will first pop all such elements that are currently at the top of stack and having a value greater than or equal to the current element. Now we will set the Next Smaller Element as the element at the top of the stack if the stack is non-empty otherwise we will set it as -1. Now we will push that element into the stack and move ahead.

// Let ans be an array of length N that stores the Next Smaller Elements.

 

// Steps :

// 1. Create an empty stack of type integer and push -1 to it .
// 2. Traverse the array from backwards and for every element at index 'i’,
// 3. We will pop the elements from the stack till we get the smaller element on top of the stack from the current element i.e. 
//     ARR[i] and that element will be the answer for the current element.Store the next smaller element in the array ans.
// 4. Push the current element of the array into the stack.
// 5. Return the array ans.
 

 

// This algorithm works because whenever we push an element to the stack, we know its value is greater than every element present in the stack. As we visit an array element, we know that if it's value is less than any item in the stack, it must be smaller than the element at the top of the stack because it is the largest item of the stack. Therefore we need not to do any kind of searching on the stack and we can just consider the last item every time.

// Time Complexity
// O(N), where ‘N’ is the number of elements in the array.

 

// We are traversing the array only once. Also, each element can be pushed into the array once. Thus the overall time complexity is O(N).

// Space Complexity
// O(N), where N is the number of elements in the array.

 

// The size of the stack used can be at most ‘N’. Hence, the space complexity is O(N).


/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    where N denotes the number of elements in the array.
*/

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class Solution {
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(-1);

        // Iterating through all the array elements from backwards.
        for (int i = n - 1; i >= 0; i--) {
			
                // Removing all the elements greater than or equal to current element from the stack.
                while (stk.peek() >= arr.get(i)) {
                        stk.pop();
                }

                // Setting the next smaller element as the element at top of stack.
                ans.add(stk.peek());

                // Pushing the current element into the stack.
                stk.push(arr.get(i));

        }

        // Returning the final vector after all the iterations.
        Collections.reverse(ans);
        return ans;
    }
}