// Brute Force
/*
We'll check for each possible combinations which can sum up to target. If we get one pair which actually sums up to target we'll
return the indexes of the pair.
 */
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target)return new int[]{i,j};
            }
        }
        return res;
    }
}
// TC - o(N^2) , SC - o(1)

// Better

/*
How to solve the above question in one Iteration and also in O(n) Complexity?

1. Iterate through the array.
2. In Each Iteration, Check  whether x = target - nums[i] is present in the Map or not.
3. If it is present in map, then simply store the index :- (map.get(x), i) in the ans array.
4. If the x is not present in the map. Then store index of current element in the map.  map.put(nums[i], i).

Note :- Map is used to store the index of the element traversed so far.
               You don't have to bother about the duplicate element in the array 
			    as this solution will take care of it.
 */

 class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}

// TC - o(N) , sc - o(N)