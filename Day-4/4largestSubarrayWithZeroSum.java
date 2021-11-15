/*
Naive Approach: This involves the use of brute force where two nested loops are used. The outer loop is used to fix the starting position of the sub-array, and the inner loop is used for the ending position of the sub-array and if the sum of elements is equal to zero, then increase the count.

Algorithm:  

1. Consider all sub-arrays one by one and check the sum of every sub-array.
2. Run two loops: the outer loop picks the starting point i and the inner loop tries all sub-arrays starting from i.
 */


// Java code to find the largest subarray
// with 0 sum
class GFG {
    // Returns length of the largest subarray
    // with 0 sum
    static int maxLen(int arr[], int n)
    {
        int max_len = 0;

        // Pick a starting point
        for (int i = 0; i < n; i++) {
            // Initialize curr_sum for every
            // starting point
            int curr_sum = 0;

            // try all subarrays starting with 'i'
            for (int j = i; j < n; j++) {
                curr_sum += arr[j];

                // If curr_sum becomes 0, then update
                // max_len
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }

    public static void main(String args[])
    {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int n = arr.length;
        System.out.println("Length of the longest 0 sum "
                           + "subarray is " + maxLen(arr, n));
    }
}
// This code is contributed by Kamal Rawal
/*
Complexity Analysis:  

Time Complexity: O(n^2) due to the use of nested loops.
Space complexity: O(1) as no extra space is used.
 */


 /*
 Efficient Approach: The brute force solution is calculating the sum of each and every sub-array and checking whether the sum is zero or not. Let's now try to improve the time complexity by taking an extra space of 'n' length. The new array will store the sum of all the elements up to that index. The sum-index pair will be stored in a hash-map. A Hash map allows insertion and deletion of key-value pair in constant time. Therefore, the time complexity remains unaffected. So, if the same value appears twice in the array, it will be guaranteed that the particular array will be a zero-sum sub-array. 
 




Mathematical Proof:  



prefix(i) = arr[0] + arr[1] +...+ arr[i] 
prefix(j) = arr[0] + arr[1] +...+ arr[j], j>i 
if prefix(i) == prefix(j) then prefix(j) - prefix(i) = 0 that means arr[i+1] + .. + arr[j] = 0, So a sub-array has zero sum , and the length of that sub-array is j-i+1  



Algorithm:  


1. Create a hash map (hm) to store the sum-index pair as a key-value pair.
2. Move along the input array from the start to the end.
3. For every index, update the value of sum = sum + array[i].
4. Check every index, if the current sum is present in the hash map or not.
5. If present, update the value of max_len to a maximum difference of two indices (current index and index in the hash-map) and max_len.
6. Else, put the value (sum) in the hash map, with the index as a key-value pair.
7. Print the maximum length (max_len).
  */

class GfG
{
    int maxLen(int nums[], int n)
    {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0 , maxlen = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            // for TC like {-1,1,-1,1}
            if(sum == 0){
                maxlen = Math.max(maxlen , i+1);
            }
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                if(len > maxlen)maxlen = len;
            }
            else{
             map.put(sum , i);   
            }
        }
        return maxlen;
    }
}

/*
Complexity Analysis: 


Time Complexity: O(n), as use of the good hashing function, will allow insertion and retrieval operations in O(1) time.
Space Complexity: O(n), for the use of extra space to store the elements in hashmap.
 */