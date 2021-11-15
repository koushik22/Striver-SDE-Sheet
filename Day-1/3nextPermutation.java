/*Summary

We need to find the next lexicographic permutation of the given list of numbers than the number formed by the given array.

Solution
Approach 1: Brute Force
Algorithm

In this approach, we find out every possible permutation of list formed by the elements of the given array and find out the permutation which is just larger than the given one. But this one will be a very naive approach, since it requires us to find out every possible permutation which will take really long time and the implementation is complex. Thus, this approach is not acceptable at all. Hence, we move on directly to the correct approach.

Complexity Analysis

Time complexity : O(n!)O(n!). Total possible permutations is n!n!.
Space complexity : O(n)O(n). Since an array will be used to store the permutations.*/

/*

 // Method 2 - Optimal Approach
INTUTION

Eg:
1 2 3 4 5
1 2 3 5 4
1 2 4 3 5
1 2 4 5 3
1 2 5 3 4
1 2 5 4 3
1 3 2 4 5
1 3 2 5 4
1 3 4 2 5
1 3 4 5 2
1 3 5 2 4
1 3 5 4 2
.... and so on

The commonality among all these sequences is that they first increase, then decrease, then increases and so on. However, to get
 the just next sequence we will concentrate our attention on the last hill.

Eg : 1 3 5 <break_point> 4 2
Now, the next greater permutation must have a smallest possible number, larger than 3(at index 1) and not at 5(index 2) as,
 5 is the peak.
So, as the prefix of the array is in decreasing order we traverse the array from the back and look for the first element greater
 than 3 (in this case 4(index3)).
Now, swap the values at index 1 and index 3.
This, gives us: 1 4 5 3 2
However, the process is yet not complete. As, we have replace a greater value at index 1, the prefix from index 2 must be in 
its lowest possible form.
But this can be easily achived by reversing this prefix as it was in descending order.
Result: 1 4 2 3 5
 */

/*
HOW:

1.Find the largest index i such that nums[i] < nums[i + 1]. If no such index exists, just reverse nums and done.
2.Find the largest index j > i such that nums[i] < nums[j].
3.Swap nums[i] and nums[j].
4.Reverse the sub-array nums[i + 1:]
 */

 class Solution {
    public void nextPermutation(int[] nums) {
        // base cases
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        
        // find the first break point
        while(i >= 0 && nums[i] >= nums[i + 1]) i--; 
        if(i >= 0) {                           
            int j = nums.length - 1;              
            while(nums[j] <= nums[i]) j--;      
            swap(nums, i, j);                     
        }
        reverse(nums, i + 1, nums.length - 1);      
}

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

}