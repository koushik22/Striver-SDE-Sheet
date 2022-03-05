// Naive Approach using two nested loops

/*
Approach 1: Brute force
Intuition

Do as directed in question. For each element in the array, we find the maximum level of water it can trap after the rain, which is equal to the minimum of maximum height of bars on both the sides minus its own height.

Algorithm:

Initialize total_water = 0
    Iterate the array from left to right:
    for each index i , calculate leftmax between height[0,i] and calculate rightmax between height[i,n-1]. Then calculate 
    total_water = Math.min(lmax,rmax) - height[i] for each ith index.
 */

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total_water = 0;
        int lmax , rmax;
        for(int i = 0; i  < height.length; i++){
            lmax = 0;
            rmax = 0;
            
            for(int j = 0; j <= i; j++){
                lmax = Math.max(lmax , height[j]);
            }
            
            for(int j = i; j <= n-1; j++){
                rmax = Math.max(rmax , height[j]);
            }
            
            
            total_water += Math.min(lmax,rmax) - height[i];
        }
        return total_water;
    }
}

/*
Complexity Analysis

Time complexity: O(n^2). For each element of array, we iterate the left and right parts.

Space complexity: O(1) extra space.
 */


// Better Approach using prefixSum and suffixSum array

/*
Method 2: This is an efficient solution to the above problem.



Approach: In the previous solution, to find the highest bar on the left and right, array traversal is needed which reduces the efficiency of the solution. To make this efficient one must pre-compute the highest bar on the left and right of every bar in linear time. Then use these pre-computed values to find the amount of water in every array element.
 */

class Solution {
    public int trap(int[] height) {
        int total_water = 0;
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int lmax = 0 , rmax = 0;
        
        for(int i = 0; i < n; i++){
            lmax = Math.max(height[i],lmax);
            pre[i] = lmax; 
        }
        
        for(int i = n-1; i >= 0; i--){
            rmax = Math.max(rmax,height[i]);
            suf[i] = rmax;
        }
        
        for(int i = 0; i < n; i++){
            total_water += Math.min(pre[i] , suf[i]) - height[i];
        }
        
        return total_water;
    }
}

// TC - O(n) and SC - O(2n)


// Most Optimal Solution
/*
Instead of maintaining two arrays of size n for storing the left and a right max of each element, maintain two variables to store the maximum till that point. Since water trapped at any element = min(leftmax, rightmax) – arr[i]. Calculate water trapped on smaller elements out of A[lo] and A[hi] first and move the pointers till lo doesn’t cross hi.


Intuition :
arr[left] or arr[right] always is a pointer to a value which is the max value found so far, searching from left and right.

If arr[left] <= arr[right], this means that arr[right] is the max value found so far. This also means that maxLeft will be less than or equal to arr[right], which means that maxLeft will be bounding the addition to the answer(total_water variable, in this solution), since it has to be less than or equal to arr[right] e, so we don't have to consider maxRight when adding to the answer.

If arr[left] > arr[right] , this means at arr[left] is the max value found so far. Same thing applies as explained in the paragraph above.
 */

class Solution {
    public int trap(int[] height) {
     int total_water = 0;
     int leftmax = 0 , rightmax = 0;
     int left = 0 , right = height.length - 1;
        
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftmax){
                    leftmax = height[left];
                }
                else{
                    total_water += leftmax - height[left];
                }
                left++;
            }
            else{
                if(height[right] >= rightmax){
                    rightmax = height[right];
                }
                else{
                    total_water += rightmax - height[right];
                }
                right--;
            }
        }
        
        return total_water;
    }
}