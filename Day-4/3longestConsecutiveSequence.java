// Approach-1(Sort + Linear Iteration)
/*
Algorithm

Before we do anything, we check for the base case input of the empty array. The longest sequence in an empty array is, of course, 0, so we can simply return that. For all other cases, we sort nums and consider each number after the first (because we need to compare each number to its previous number). If the current number and the previous are equal, then our current sequence is neither extended nor broken, so we simply move on to the next number. If they are unequal, then we must check whether the current number extends the sequence (i.e. nums[i] == nums[i-1] + 1). If it does, then we add to our current count and continue. Otherwise, the sequence is broken, so we record our current sequence and reset it to 1 (to include the number that broke the sequence). It is possible that the last element of nums is part of the longest sequence, so we return the maximum of the current sequence and the longest one.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int maxi = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1] + 1)count++;
            else if(nums[i] == nums[i-1]){
                continue;
            }
            else{
                maxi = Math.max(maxi,count);
                count = 1;
            }
        }
        maxi = Math.max(maxi,count);
        return maxi;
    }
}


// Optimal Solution - o(n) time and o(n) space.
/*
    Intuition:
    Iterate over each element say nums[i] and check if (nums[i] - 1) exists in given array.
    If (nums[i] - 1) exists, that means there exists a smaller element than nums[i] and possibly 
	required sequence could start from that element. Hence we will move further 
	ignoring nums[i] as it is sure that required sequence could not start from nums[i].
    If (nums[i] - 1) does not exist, that means nums[i] is the smallest element of one 
	of the possible sequence. Hence we would start counting from nums[i] and see 
	if other consecutive elements of nums[i] exists in the array.
    */


class Main
{
    // Function to find the length of the largest subsequence formed by
    // consecutive integers
    public static int findMaxLenSubseq(int[] arr)
    {
        // construct a set out of input elements
        Set<Integer> S = new HashSet<>();
        for(int ele : arr)S.add(ele);
 
        // initialize result by 0
        int maxLen = 0;
 
        // do for each element of the input sequence
        for (int e: arr)
        {
            // check if the current element `e` is a candidate for starting a sequence,
            // i.e., the previous element `e-1` doesn't exist in the set
            if (!S.contains(e - 1))
            {
                // `len` stores the length of subsequence, starting with the
                // current element
                int len = 1;
 
                // check for presence of elements `e+1`, `e+2`, `e+3`, … ,`e+len`
                // in the set
                while (S.contains(e + len)) {
                    len++;
                }
 
                // update result with the length of current consecutive subsequence
                maxLen = Math.max(maxLen, len);
            }
        }
 
        // return result
        return maxLen;
    }

    
 // Alternate code
    class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
    /*
Complexity Analysis

Time complexity : O(n)

Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for nn iterations throughout the entire runtime of the algorithm. This means that despite looking like o(n^2) complexity, the nested loops actually run in O(n + n) = O(n) time. All other computations occur in constant time, so the overall runtime is linear.

Space complexity : O(n).

In order to set up O(1)O(1) containment lookups, we allocate linear space for a hash table to store the O(n)O(n) numbers in nums. Other than that, the space complexity is identical to that of the brute force solution.

     */