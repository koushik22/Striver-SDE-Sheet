// Problem Statement: Given an array arr of distinct integers, print all permutations of String/Array.



// Solution 1: Recursive

// Approach: We have given the nums array, so we will declare an ans vector of vector that will store all the permutations also declare a data structure.

// Declare a map and initialize it to zero and call the recursive function

// Base condition:

// When the data structure’s size is equal to n(size of nums array)  then it is a permutation and stores that permutation in our ans, then returns it.

// Recursion:

// Run a for loop starting from 0 to nums.size() – 1. Check if the frequency of i is unmarked, if it is unmarked then it means it has not been picked and then we pick. And make sure it is marked as picked.

// Call the recursion with the parameters to pick the other elements when we come back from the recursion make sure you throw that element out. And unmark that element in the map.

  public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> finalResult = new ArrayList<>();
        permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
        return finalResult;
    }

    private void permuteRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])continue;

            currResult.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }


// Time Complexity:  N! x N

// Space Complexity:  O(N)



            // Solution 2: With Backtracking.

// Approach: Using backtracking to solve this.

// We have given the nums array, so we will declare an ans vector of vector that will store all the permutations.

// Call a recursive function that starts with zero, nums array, and ans vector.

// Declare a map and initialize it to zero and call the recursive function

// Base condition:

// Whenever the index reaches the end take the nums array and put it in ans vector and return.

// Recursion:

// Go from index to n – 1 and swap. Once the swap has been done call recursion for the next state.After coming back from the recursion make sure you re-swap it because for the next element the swap will not take place.


import java.io.*;
import java.util.*;
class Solution {
    private void recurPermute(int index, int[] nums, List < List < Integer >> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List < List < Integer >> permute(int[] nums) {
        List < List < Integer >> ans = new ArrayList < > ();
        recurPermute(0, nums, ans);
        return ans;
    }
}


// Time Complexity: O(N! X N)

// Space Complexity: O(1)

