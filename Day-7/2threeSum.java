/*
METHOD 1. Naive approach: Use three for loops
The naive approach is to just use three nested for loops and check if the sum of any three elements in the array is equal to the given target.

Time complexity: O(n^3)
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)return res;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        // sort to ensure no duplicate triplets are inserted
                        Collections.sort(temp); 
                        
                        if(!res.contains(temp))
                            res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}

/*
METHOD 2. Use Sorting along with the two-pointer approach
Another approach is to first sort the array, then -

Iterate through each element of the array and for every iteration,
Fix the first element (nums[i])
Try to find the other two elements whose sum along with nums[i] gives target. This boils down to the two sum problem.

Time complexity: O(n^2)
 */

 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)return res;
        
        Arrays.sort(nums);
        
        for(int i=0;i<=nums.length-3;i++){
            int target = -nums[i];
            
            int front = i+1 , back = nums.length - 1;
            
            while(front < back){
                int two_sum = nums[front] + nums[back];
                if(target < two_sum){
                    back--;
                }
                else if(target > two_sum){
                    front++;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[front]);
                    temp.add(nums[back]);
                    
                    res.add(temp);
                     // remove duplicacy because of front
                    while(front < back && nums[front] == temp.get(1))front++;
                    // remove duplicacy because of back
                    while(front < back && nums[back] == temp.get(2))back--;
                }
            }
            // remove duplicacy because of i.
            while(i+1 < nums.length && nums[i] == nums[i+1])i++;
        }
        return res;
    }
}