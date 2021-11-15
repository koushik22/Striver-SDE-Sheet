// Brute Force - Using a 3rd array of size(m+n).

// Optimal Approaches

// Approach 1 - Insertion Sort Type Algo
/*
The idea is simple. Consider each array element X[] and ignore it if it is already in the correct order 
(i.e., the element smallest among all remaining elements); otherwise, swap it with the smallest element, which
 happens to be the first element of Y[]. After swapping, move the element (now present at Y[0]) to its correct position in
  Y[] to maintain the sorted order.
 */

 import java.util.Arrays;
 
class Main
{
    // Function to in-place merge two sorted arrays X[] and Y[]
    // invariant: `X[]` and `Y[]` are sorted at any point
    public static void merge(int[] X, int[] Y)
    {
        int m = X.length;
        int n = Y.length;
 
        // Consider each element `X[i]` of array `X` and ignore the element if it is
        // already in the correct order; otherwise, swap it with the next smaller
        // element, which happens to be the first element of `Y`.
        for (int i = 0; i < m; i++)
        {
            // compare the current element of `X[]` with the first element of `Y[]`
            if (X[i] > Y[0])
            {
                // swap `X[i] with `Y[0]`
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;
 
                int first = Y[0];
 
                // move `Y[0]` to its correct position to maintain the sorted
                // order of `Y[]`. Note: `Y[1…n-1]` is already sorted
                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }
 
                Y[k - 1] = first;
            }
        }
    }
 
    public static void main (String[] args)
    {
        int[] X = { 1, 4, 7, 8, 10 };
        int[] Y = { 2, 3, 9 };
 
        merge(X, Y);
 
        System.out.println("X: " + Arrays.toString(X));
        System.out.println("Y: " + Arrays.toString(Y));
    }
}
// The time complexity of the above solution is O(m.n), where m is the size of the first array and n is the size of the
// second array. The solution doesn’t require any extra space


// Approach - 2(Gap Method)
/*The idea: We start comparing elements that are far from each other rather than adjacent. 
For every pass, we calculate the gap and compare the elements towards the right of the gap. Every pass, the gap 
reduces to the ceiling value of dividing by 2.
*/

// Java program for Merging two sorted arrays
// with O(1) extra space

public class MergeTwoSortedArrays {

	// Function to find next gap.
	private static int nextGap(int gap)
	{
		if (gap <= 1)
			return 0;
		return (gap / 2) + (gap % 2);
	}

	private static void merge(int[] arr1,
							int[] arr2, int n,
							int m)
	{
		int i, j, gap = n + m;
		for (gap = nextGap(gap); gap > 0;
			gap = nextGap(gap))
		{
			// comparing elements in the first
			// array.
			for (i = 0; i + gap < n; i++)
				if (arr1[i] > arr1[i + gap])
				{
					int temp = arr1[i];
					arr1[i] = arr1[i + gap];
					arr1[i + gap] = temp;
				}

			// comparing elements in both arrays.
			for (j = gap > n ? gap - n : 0;
				i < n && j < m;
				i++, j++)
				if (arr1[i] > arr2[j])
				{
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}

			if (j < m)
			{
				// comparing elements in the
				// second array.
				for (j = 0; j + gap < m; j++)
					if (arr2[j] > arr2[j + gap])
					{
						int temp = arr2[j];
						arr2[j] = arr2[j + gap];
						arr2[j + gap] = temp;
					}
			}
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		int[] a1 = { 10, 27, 38, 43, 82 };
		int[] a2 = { 3, 9 };

		// Function Call
		merge(a1, a2, a1.length, a2.length);

		System.out.print("First Array: ");
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");
		}

		System.out.println();

		System.out.print("Second Array: ");
		for (int i = 0; i < a2.length; i++) {
			System.out.print(a2[i] + " ");
		}
	}
}

// This code is contributed by Vinisha Shah
