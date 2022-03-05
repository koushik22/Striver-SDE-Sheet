class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = 0;
        for(int i = 0;i<nums.length;i++) {
            // if the element is 1, increment count
            if(nums[i] == 1) {
                cnt++; 
            }
            // else make count = 0 for the next elements
            else {
                cnt = 0; 
            }
            // update maxi if count > maxi
            maxi = Math.max(maxi, cnt); 
        }
        return maxi; 
    }
}