/*
Brute-Force
The simplest possible solution to this problem is to apply brute force and find the pairs which satisfy the required conditions.
We can use two nested loops, one for index ‘i’ and another for index ‘j’, so that we can compare all the pairs.
Let variable count store the number of Reverse Pairs.
Now, the algorithm will be as follows :
L1: For i = 1 to N, considering all the indices of the array.
L2: For j = i + 1 to N, considering all the indices greater than i.
Since we already know that i < j, we can check if ARR[i] > 2 * ARR[j] satisfies:
increment count by 1, i.e. count = count + 1.
Finally, return the count.
Note that L1 and L2 are two nested loops.
Time Complexity
O(N ^ 2), Where N is the number of elements in the given array/list.

 

Since we are considering every index j for given index i, such that j > i, we will have (N * (N - 1)) / 2 pairs to consider. Hence the overall complexity will be O(N ^ 2).

Space Complexity
O(1).

 

Since we are using constant extra space.
 */

 /*
        Time Complexity: O(N ^ 2)
        Space Complexity: O(1)

        Where N is the size of the array.
*/

import java.util.ArrayList;

public class Solution 
{
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        int n = arr.size();

        int ans = 0;

        // Iterate i from 0 to n
        for (int i = 0; i < n; i++) 
        {
            // Iterate j from i + 1 to n
            for (int j = i + 1; j < n; j++) 
            {
                if (arr.get(i) > arr.get(j) * 2) 
                {
                    ans++;
                }
            }   
        }

        return ans;
    }
}

/*
Approach 2 - Modified merge sort

Since the previous approach was very inefficient for large values of N, we can use some kind of modified merge sort to solve this problem.

Since merge sort works on divide and conquer paradigm, so, first we divide the array into smaller sorted arrays and merge them to form a completely sorted array.

We can count the number of pairs which satisfies the above conditions while merging the array.

Let mergeSort() be a recursive integer function which takes the array, starting pointer ‘S’ which points to the start of array and ending pointer ‘E’, which points to the end of the array which we are considering.

mergeSort(), after processing the left sub-array and right sub-array that means after sorting the each sub-array, during merging
of the two arrays we'll count the pairs which will satisfy the above conditions.

In each round we try to divide the array into two parts and sort them.
Look at the code below for better understanding of mergeSort:

 */

 // For better understanding make a dry run with [40,25,19,12,9,6,2] this array.

 class Solution {
    
    int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        // left sub-arr id from[low,mid], right sub-arris from [mid+1,high]
        int j = mid + 1; 
        // count no of pairs
        for(int i = low;i<=mid;i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid+1));
        }
        // merge two arrays
        ArrayList<Integer> temp = new ArrayList(); 
        int left = low, right = mid+1; 
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]); 
            }
            else {
                temp.add(nums[right++]); 
            }
        }
        
        while(left<=mid) {
            temp.add(nums[left++]); 
        }
        while(right<=high) {
            temp.add(nums[right++]); 
        }
        
        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low); 
        }
        return cnt; 
    }
    int mergeSort(int[] nums, int low, int high) {
        // forn single element, count of pairs will be '0'.
        if(low>=high) return 0; 
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid); 
        inv += mergeSort(nums, mid+1, high); 
        inv += merge(nums, low, mid, high); 
        return inv; 
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1); 
    }
}