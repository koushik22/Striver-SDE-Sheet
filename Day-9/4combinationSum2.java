/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */

 // Approach 1 - Brute Force
 /*
 Just like combinationSum1, we can go about the same approach. But only 1 difference is that here after picking any element
 we need to move to next index unlike of previous problem. Here instead of List<List> we need to use Set<List> to avoid
 duplicates in the array. Then again we need to conver Set<List>> to List<List>> to return the answer.

 TC - 2^n * k * log m( where m = set size), here log m is needed to insert the List<Integer> data structure inside a 
 Set data structure.
  */

  // Approach 2 - Efficient Solution

  class Solution {
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
    //  Base case: if the sum of the path satisfies the target, we will consider 
    // it as a solution, and stop there
        if(target == 0) {
            ans.add(new ArrayList<>(ds)); 
            return; 
        }
        
        for(int i = ind; i < arr.length;i++) {
            /*
            Very important here! We use `i > ind` because we always want 
            to count the first element in this recursive step even if it is the same 
            as one before. To avoid overcounting, we just ignore the duplicates
            after the first element.
             */
            if(i > ind && arr[i] == arr[i-1]) continue; 

            /*
            If the current element is bigger than the assigned target, there is 
             no need to keep searching, since all the numbers are positive 
             */
            if(arr[i]>target) break; 
            ds.add(arr[i]); 
            //  We change the start to `i + 1` because one element only could
            //  be used once
            findCombinations(i+1, arr, target - arr[i], ans, ds); 
            ds.remove(ds.size() - 1); 
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); 
        findCombinations(0, candidates, target, ans, new ArrayList<>()); 
        return ans; 
    }
}

// TC -  2^n * k, where k is the avg length of every combinations.
// SC - k * x, where x is the number of combinations generated