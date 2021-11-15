// Approach-1(SORT -> Three Pointers + Binary Search)

// ARR - {10,2,3,3,4,5,9,7,5,8,10,9}
/*
we'll keep a pointer i at 0 , j at i+1 , k at j+1, and we'll apply a binary search to find target - nums[i] - nums[j] - nums[k]
in ARR[k+1 , n-1]. If we can find (target - nums[i] - nums[j] - nums[k]) in the array then we'll put these 4 elemnts
(nums[i],nums[j],nums[k],target - nums[i] - nums[j] - nums[k]) in a hashset to avoid duplicacy, then we'll return answer.


// TC - 0(n^3) + o(logn) + o(nlogn)
// SC - o(N) approximately
 */

 // Optimal Solution

/*
we'll sort the array and run two loops of i and j and also use two pointers front and back to calculate target_2. We'll not check over for duplicate elements rather we'll jump over to unique elements only(both in loops of i , j and also in pointers of front and back).
 */
 class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null)return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                // find two_sum with front & back pointer.
                int target_2 = target - nums[i] - nums[j];
                int front = j+1;
                int back = n-1;
                while(front<back){
                    int two_sum = nums[front]+nums[back];
                    if(two_sum<target_2){
                        front++;
                    }
                    else if(two_sum>target_2){
                        back--;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);
                        
                        // to avoid duplicacy due to front
                        while(front<back && nums[front] == quad.get(2))front++;
                        // to avoid duplicacy due to back
                        while(front<back && nums[front] == quad.get(3))back--;
                    }
                }
                // to avoid duplicacy due to j, we have kept j one step back from final position as it will get forward 1 step as it is in loop.
                while(j+1<n && nums[j+1] == nums[j])j++;
            }
            // to avoid duplicacy due to i, we have kept i one step back from final position as it will get forward 1 step as it is in loop.
            while(i+1<n && nums[i+1] == nums[i])i++;
        }
        return res;
    }
}