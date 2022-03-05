/*
Problem Statement:
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.
 */


// Approach 1 - Using a ordered set

/*
we'll put all the unique elements in the set and return set.size() as answer which is total number of unique elements.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int count = 0;
        for(int ele : nums){
            set.add(ele);
        }
        
        int k = 0;
        // placing unique elements in the first part of the array.
        for(int ele : set)nums[k++] = ele;
        
        return set.size();
    }
}

// TC - O(N) , SC - O(N)

// Apprach 2 - In-place modification of the array

/*
Since the array is already sorted, we just need to traverse the elements by starting from index 1. The idea is finding a case where the neighbour values are different from each other, which represents non-duplication. We do not need to concentrate on the remaining values of the array on the right side after the loop finishes.
 */

 class Solution {
    public int removeDuplicates(int[] nums) {
       int i = 0;
        
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        // upto ith index unique elements are present. As it is a 0-indexed array the total elements are i+1
        return i+1;
    }
}