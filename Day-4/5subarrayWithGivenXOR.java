/*
A Simple Solution is to use two loops to go through all possible subarrays of arr[] and count the number of subarrays having XOR of their elements as m. 
 */

 // A simple Java Program to count all
// subarrays having XOR of elements
// as given value m
public class GFG {

	// Simple function that returns
	// count of subarrays of arr with
	// XOR value equals to m
	static long subarrayXor(int arr[],
							int n, int m)
	{
		
		// Initialize ans
		long ans = 0;

		// Pick starting point i of
		// subarrays
		for (int i = 0; i < n; i++)
		{
			
			// Store XOR of current
			// subarray
			int xorSum = 0;

			// Pick ending point j of
			// subarray for each i
			for (int j = i; j < n; j++)
			{
				
				// calculate xorSum
				xorSum = xorSum ^ arr[j];

				// If xorSum is equal to
				// given value, increase
				// ans by 1.
				if (xorSum == m)
					ans++;
			}
		}
		
		return ans;
	}

	// Driver code
	public static void main(String args[])
	{

		int[] arr = { 4, 2, 2, 6, 4 };
		int n = arr.length;
		int m = 6;

		System.out.println("Number of subarrays"
					+ " having given XOR is "
					+ subarrayXor(arr, n, m));
	}
}

//The Time Complexity of the above solution is O(n^2).

// Approach - 2

/*
Optimized Approach
The basic idea of this approach is to use a HashMap to store the prefix XOR of the subarray. We’ll iterate over the given array/list and calculate the number of subarrays ending at a particular index and having an XOR sum of ‘X’.


 

Now consider the following steps:

Create a HashMap “prefXor” which stores the count of subarrays having a particular XOR value.
Create a variable “curXor” which stores the XOR for ‘i’ elements. Initialise it with zero. Also, create a variable called “ans” to store the count of the subarrays having XOR ‘X’.
Start iterating through given array/list using a variable ‘i’ such that 0 <= ‘i’ < n
Update the “curXor” i.e. curXor = curXor ^ arr[i]
Store the required value of the prefix Xor to make the XOR of the subarray ending at the current index equal to X i.e. req = X ^ curXor
Now add the count of prefix arrays with required xor i.e. ans  = ans + prefXor[req]
Update the “prefXor” HashMap with the “curXor” i.e. prefXor[curXor] = prefXor[curXor] + 1
Time Complexity
O(N), Where 'N' denotes the number of elements in the given array.

 

We are using a HashMap to store the prefix XORs which takes O(1) time on average for “get” and “put” operations. And we are performing O(N) such operations. So the overall time complexity will be O(N).

Space Complexity
O(N), Where 'N' denotes the number of elements in the given array.

 

We are using a HashMap to store the prefix XORs which will store at max ‘N’ elements. So the overall space complexity will be O(N).

 */

 /*
    Time Complexity : O(N)
    Space Complexity : O(N)
    
    Where 'N' denotes the number of elements in the given array.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		int n = arr.size();

		// To store the prefix XOR's.
		HashMap<Integer, Integer> prefXor = new HashMap<Integer, Integer>();

		int ans = 0;

		// To keep track of the current xor.
		int currXor = 0;

		// Intialy Xor is 0.
		prefXor.put(0, 1);

		for (int i = 0; i < n; i++) {
			// Update the Xor of the current prefix.
			currXor = currXor ^ arr.get(i).intValue();

			// Required value of the prefix Xor to make the xor of the subarray ending at
			// the current index equal to X.
			int req = x ^ currXor;

			// Add the count of prefix arrays with required xor.
			if (prefXor.containsKey(req)) {
				ans += prefXor.get(req);
			}

			if (prefXor.containsKey(currXor)) {
				prefXor.put(currXor, prefXor.get(currXor) + 1);
			} else {
				prefXor.put(currXor, 1);
			}
		}

		return ans;
	}
}
