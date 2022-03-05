//Problem Statement: 

/*
Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
*/



// Solution: Recursion

/*
Intuition:

For questions like printing combinations or subsequences, the first thing that should strike your mind is recursion.

How to think recursively?

Whenever the problem is related to picking up elements from an array to form a combination, start thinking about the “pick and non-pick” approach.
 */

// Thinking:
 /*
 Initially, the index will be 0, target as given and the data structure(vector or list) will be empty

Now there are 2 options viz to pick or not pick the current index element.

If you pick the element, again come back at the same index as multiple occurrences of the same element is possible so the target reduces to target – arr[index] (where target -arr[index]>=0)and also insert the current element into the data structure.

If you decide not to pick the current element, move on to the next index and the target value stays as it is. Also, the current element is not inserted into the data structure.

While backtracking makes sure to pop the last element as shown in the recursion tree below.

Keep on repeating this process while index < size of the array for a particular recursion call.

You can also stop the recursion when the target value is 0, but here a generalized version without adding too many conditions is considered.

Using this approach, we can get all the combinations.

**Base condition**
    If index== size of array and  target == 0 include the combination in our answer
  */

  class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res  = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        combinationSum(0 , target , candidates , ds , res);        
        return res;
    }
    
    void combinationSum(int idx , int target , int[] candidates , 
                       List<Integer> ds , List<List<Integer>> res){
        
        if(idx == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        
        // pick
        if(candidates[idx] <= target){
            ds.add(candidates[idx]);
            combinationSum(idx , target - candidates[idx] , candidates , ds , res);
            ds.remove(ds.size() - 1);
        }
        
        // non pick
        combinationSum(idx+1 , target , candidates , ds , res);
    }
}

/*
Time Complexity: O(2^t * k) where t is the target, k is the average length

Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)

Why not (2^n) but (2^t) (where n is the size of an array)?

Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.

Space Complexity: O(k*x), k is the average length and x is the no. of combinations
 */



  