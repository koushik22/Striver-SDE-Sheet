// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

// i. countAndSay(1) = "1"
// ii. countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
// To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

// For example, the saying and conversion for digit string "3322251":

// Given a positive integer n, return the nth term of the count-and-say sequence.

// Approach: The key point here is to find the maximum consecutive identical numbers, which means, for example:

// Say there is a array like this [1, 1, 2, 3, 4, 4, 5, 5, 5], we will need to divide the array into different segments like this, [1, 1], [2], [3], [4, 4], [5, 5, 5]. Only in this way, can we count the occurrence of each consecutive segments and convert them into "21 12 13 24 35".

// The description of the problem is misleading and I struggled for a while, after some searching I found the right explanation. The number n has nothing to do with the algorithm directly, but but only control the number of iteration.

// The problem can be solved by using iterative algorithm.


class Solution {
    public String countAndSay(int n) {
        // Base Cases
        if(n == 1)return "1";
        if(n == 2)return "11";
        
        StringBuilder s = new StringBuilder("11");
        
        for(int i = 3; i <= n; i++){
            // Append with "$" for the count of last Integer
            s.append("$");
            int c = 1;
            // Initialize a new t for each ith iteration
            StringBuilder t = new StringBuilder("");
            for(int j = 1; j < s.length(); j++){
                // If current character is different than last character, then we'll make the answer so far and also make count = 1
                if(s.charAt(j) != s.charAt(j - 1)){
                    t.append(Integer.toString(c));
                    t.append(s.charAt(j - 1));
                    c = 1;
                }
                // Otherwise we'll increment the counter
                else{
                    c++;
                }
            }
            s = t;
        }
        return s.toString();
    }
}