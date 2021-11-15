class Solution {
    public int findDuplicate(int[] nums) {
        
        // Brute Force. TC - o(n^2) , Sc - O(1)
        for(int i = 0; i < nums.length; i++){
            for(int j=i+1; j < nums.length;j++){
                if(nums[i] == nums[j])return nums[i];
            }
        }
        return -1;
    }
}
        
        // Better Solution using Hashing. TC - o(n) , Sc - O(N)
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums){
            if(set.contains(ele))return ele;
            else{
                set.add(ele);
            }
        }
        return -1;
        
        
        // Better Solution using sort. TC - O(nlogn) + o(n)
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])return nums[i];
        }
        return -1;
        
        // Optimal Solution : Using Linked List Cycle Finding Method
        /*
        The main idea is the same with problem Linked List Cycle II,https://leetcode.com/problems/linked-list-cycle-ii/. 
        Use two pointers the fast and the slow. The fast one goes forward two steps each time, while the slow one goes only 
        step each time. They must meet the same item when slow==fast. In fact, they meet in a circle, the duplicate number 
        must be the entry point of the circle when visiting the array from nums[0]. Next we just need to find the entry point. 
        We use a point(we can use the fast one before) to visit form begining with one step each time, do the same job to slow. 
        When fast==slow, they meet at the entry point of the circle. The easy understood code is as follows.
         */
        
        int slow = nums[0];
        int fast = nums[0];
        
        slow = nums[slow];
        fast = nums[nums[fast]];
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}