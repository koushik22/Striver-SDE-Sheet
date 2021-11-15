 // Method - 1(Brute Force)
 /*Use 3 loops of i , j  & k and generate each subarray and find the maximum sum of the subarray
 TC - O(n^3)
 */
 // Method - 1(Better)
/*Intsead off two loops use 2 loops i , j where i[0 : arr.length - 1] & j[i : arr.length - 1] and during each iteration of i
add nums[j] in the result i.e. res += nums[j]. Hence find the maximum sum.
TC - O(n^2)
*/

 // Method - 3(Kadane's Algo)
/*
Kadane’s Algorithm is an iterative dynamic programming algorithm. It calculates the maximum sum subarray ending at a 
particular position by using the maximum sum subarray ending at the previous position. Follow the below steps to solve the 
problem.

1. Define two-variable currSum which stores maximum sum ending here and maxSum which stores maximum sum so far.
2. Initialize currSum with 0 and maxSum with INT_MIN.
3. Now, iterate over the array and add the value of the current element to currSum and check
4. If currSum is greater than maxSum, update maxSum equals to currSum.
5. If currSum is less than zero, make currSum equal to zero.
6. Finally, print the value of maxSum.
 */

 public int maximumSubarraySum(int[] arr) {
  int n = arr.length;
  int maxSum = Integer.MIN_VALUE;
  int currSum = 0;

  for (int i = 0; i <= n - 1; i++) {
    currSum += arr[i];

    if (currSum > maxSum) {
      maxSum = currSum;
    }

    if (currSum < 0) {
      currSum = 0;
    }
  }

  return maxSum;
}