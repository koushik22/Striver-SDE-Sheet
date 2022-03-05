// Solution 1: Using Linear Search

// Approach :

// We will iterate through the array completely. While iterating, we have to check if we have found the target element in the array. If we find it, we will return its index. If we iterate completely and still do not find an element in the array. This indicates the target is not present and hence we return -1 as mentioned in the question.

// Code:

import java.util.*;
public class Main {
    static int search(int arr[],int target) {
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]==target)
        return i;
    }
    return -1;
}
    public static void main(String args[]) {
    int arr[] = {4,5,6,7,0,1,2,3};
    int target = 3;
    System.out.println("The index in which the number is present is "+search(arr,target));
    }
}

    
    
// Time Complexity : O(N)

// Reason: We have to iterate through the entire array to check if the target is present in the array.

// Space Complexity: O(1)

// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


// Solution 2: Using Binary Search

// Intuition :

// It is mentioned that the array given is sorted but in a rotated manner. So, we can divide a given array into two parts that are sorted. This gives us hints to use binary search. We can visualize a given array to be composed of two sorted arrays.

// Approach :

// We divide the array into parts. It is done using two pointers, low and high, and dividing the range between them by 2. This gives the midpoint of the range. Check if the target is present in the midpoint, calculated before, of the array. If not present, check if the left half of the array is sorted. This implies that binary search can be applied in the left half of the array provided the target lies between the value range. Else check into the right half of the array. Repeat the above steps until low <= high. If low > high, indicates we have searched array and target is not present hence return -1. Thus, it makes search operations less as we check range first then perform searching in possible ranges which may have target value.

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo+hi) >> 1;
            // if target found, return its index as answer
            if(nums[mid] == target)return mid;
            
            // check if left half is sorted
            else if(nums[lo] <= nums[mid]){
                // check if the target is in the left half
                if(nums[lo] <= target && nums[mid] >= target){
                    hi = mid - 1;
                }
                // otherwise it will be in the right half
                else{
                    lo = mid + 1;
                }
            }
            else{
                // check if right half is sorted
                // and also check if the element is in the right half
                if(nums[mid] <= target && nums[hi] >= target){
                    lo = mid + 1;
                }
                // otherwise it will be in the left half
                else{
                    hi = mid - 1;
                }
            }
        }
        // if target not found in the array, return "-1" as answer
        return -1;
    }
}


// Time Complexity: O(log(N))

// Reason: We are performing a binary search, this turns time complexity to O(log(N)) where N is the size of the array.

// Space Complexity: O(1)

// Reason: We do not use any extra data structure, this turns space complexity to O(1).