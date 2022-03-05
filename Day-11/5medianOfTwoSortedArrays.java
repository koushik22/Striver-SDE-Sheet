// Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays.

// Solution 1: Naive Approach

// Intuition :

// The point to observe is that the given arrays are sorted. Our task is to merge them into a sorted array. The word “merge” gives us hints to apply the merge step of merge sort.

// Approach :

// Take two pointers, each pointing to each array. Take an array of size (m+n) to store the final sorted array. If the first pointed element is smaller than the second one, store that value in an array and move the first pointer ahead by one. Else do the same for the second pointer when the case is vice-versa. Then use the formula to get the median position and return the element present at that position.


import java.util.*;
public class TUF{
static double median(int arr1[],int arr2[],int m,int n) {
    int finalArray[]=new int[n+m];
    int i=0,j=0,k=0;
    while(i<m && j<n) {
        if(arr1[i]<arr2[j]) {
            finalArray[k++] = arr1[i++];
        }
        else {
            finalArray[k++] = arr2[j++];
        }
    }
    if(i<m) {
        while(i<m) 
            finalArray[k++] = arr1[i++];
    }
    if(j<n) {
        while(j<n)
            finalArray[k++] = arr2[j++];
    }
    n = n+m;
    if(n%2==1) 
        return finalArray[((n+1)/2)-1];
    else return ((double)finalArray[(n/2)-1]+(double)finalArray[(n/2)])/2.0;
}

public static void main(String args[]) {
    int arr1[] = {1,4,7,10,12};
    int arr2[] = {2,3,6,15};
    int m=arr1.length;
    int n =arr2.length;
   System.out.print("The Median of two sorted array is ");
    System.out.printf("%.5f",median(arr1,arr2,m,n));
}
}

// Output:

// The Median of two sorted arrays is 6.00000

// Time Complexity : O(m+n)

// Reason – We traverse through both the arrays linearly.

// Space Complexity : O(m+n)

// Reason – We store the final array whose size is m+n.

//-------------------------------------------------------------------------------------------------------------- 

// Solution 3: Efficient solution

// Intuition :

// We came up with a naive solution because of the hint that two arrays are sorted and we want elements from merged sorted arrays. If we look into the word “sorted arrays”, we can think of a binary solution. Hence, we move to an efficient solution using binary search. But how to apply binary search? Let’s look into the thought process.

// We know that we will get answers only from the final merged sorted arrays. We figured it out with the naive approach discussed above. We will partition both the arrays in such a way that the left half of the partition will contain elements, which will be there when we merge them, till the median element and rest in the other right half. This partitioning of both arrays will be done by binary search.

// Approach :

// We will do a binary search in one of the arrays which have a minimum size among the two. 

// Firstly, calculate the median position with (n+1)/2. Point two-pointer, say low and high, equal to 0 and size of the array on which we are applying binary search respectively. Find the partition of the array. Check if the left half has a total number of elements equal to the median position. If not, get the remaining elements from the second array. Now, check if partitioning is valid. This is only when l1<=r2 and l2<=r1. If valid, return max(l1,l2)(when odd number of elements present) else return (max(l1,l2)+min(r1,r2))/2.

// If partitioning is not valid, move ranges. When l1>r2, move left and perform the above operations again. When l2>r2, move right and perform the above operations.

// Code :

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensuring thath the binary search happens on the smaller array only
    if(nums2.length < nums1.length)return findMedianSortedArrays(nums2 , nums1);
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        
        int low = 0 , high = n1;
        
        while(low <= high){
        
            int cut1 = (low + high) >> 1;
            // cut2 means median position
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            
            // check if in the first array of left half have 0 elements or not
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            // check if in the second array of left half have 0 elements or not
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            // check if in the first array of right half have 0 elements or not
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            // check if in the second array of right half have 0 elements or not
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            // this is the valid conditions, if we have applied cut on the array properly
            if(left1 <= right2 && left2 <= right1){
                // for even sized array(total length)
                if((n1 + n2) % 2 == 0){
                  return (Math.max(left1 , left2) + Math.min(right1 , right2))/2.0;
                }
                // for odd sized array
                else{
                    return Math.max(left1 , left2);
                }
            }
            // In this case we need to take smaller elements in the first array of left half
            else if(left1 > right2){
                high = cut1 - 1;
            }
             // In this case we need to take greater elements in the first array of left half
            else if(left2 > right1){
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
// Output:

// The Median of two sorted arrays is 6.00000

// Time Complexity : O(log(m,n))

// Reason – We are applying binary search on the array which has a minimum size.

// Space Complexity: O(1)

// Reason – No extra array is used.