/*
Bruteforce Approach
The simplest approach to solve this problem is to generate all the substrings of the given string and among all substrings having all unique characters, return the maximum length.

Algorithm

To generate all substrings of a string, loop from the start till the end index of the string. Let us consider, the start index is i and the end index is j. Run a nested loop from i = 0 to N – 1 and j =  i + 1 till N. Hence, the substrings can be generated.
To check if the substring contains all unique characters, put all the characters in the set one by one. If any of the characters are already present in the set, skip that string, else consider its length and maximize it.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
 
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
 
        return res;
    }
    
     boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];
 
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }
         return true;
     }
}

/*
Approach - 2
The idea is use a hash set to track the longest substring without repeating characters so far, use a fast pointer j to see if character j is in the hash set or not, if not, great, add it to the hash set, move j forward and update the max length, otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.
 */

 public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
}

/*
TC - o(2n) , sc - o(1)
TestCase - "abcdefghzz", here for zz we need to traverse the whole string almost twice using two pointers.
 */

 /*
 Optimal Solution - 

 if we use hashmap to store the position of occured characters. Then we don't need to find the next start position by set.remove(s.charAt(i++)); We just put left = Math.max(i , mpp.get(s.charAt(j)) + 1); So we are simply jumping over i and not watching
 each character 1 by 1.
  */

  class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0 , right = 0 , len = 0 , n = s.length(); 
        HashMap<Character , Integer> mpp = new HashMap<>();
        
        while(right < n){
            if(mpp.containsKey(s.charAt(right))){
                left = Math.max(left , mpp.get(s.charAt(right)) + 1);
            }
            
            mpp.put(s.charAt(right) , right);
            len = Math.max(len , right - left + 1);
 
            right++;
        }
        return len;
    }
}
(
// TC - o(n) , sc - o(1)