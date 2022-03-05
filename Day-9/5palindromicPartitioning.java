// problem statement : Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// A palindrome string is a string that reads the same backward as forward.


/*
Explanation:
We will use the levels and options method to solve this problem. Let us consider the input string as "ababa". This is the string for which we will apply our procedure and find all the palindromic partitions.

What we will do at every level is that we will expand the string i.e. take out a palindromic prefix from the string till the question string becomes empty. You will understand this better when we will elaborate this procedure using a recursion tree.
 */

//  Algorithm:
// 1. Take out a palindrome prefix from the question string. If there is no palindrome prefix, this string cannot be partitioned.
// 2. If you obtain a palindrome prefix, apply the recursion call by taking the remaining string as the question string and put the prefix obtained in a empty data structure.
// 3. During backtrack remove the prefix from the data structure.
// 4. Do this till the question string becomes empty. When the question string is empty, the answer so far (asf) will have the partitioned string. Print the answer and return from the recursion.

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        partition(s , ds , res);
        return res;
    }
    
    void partition(String str , List<String> ds , List<List<String>> res){
        if(str.length() == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        
        // check for the palindromic prefix only, if palindromic prefix found, then only make further recursion call.
        for(int i = 0; i < str.length(); i++){
            // pick out the prefix
            String prefix = str.substring(0 , i+1);
            // calculate remaining steing
            String ros = str.substring(i+1);
            // check if the obtained prefix is palindrome or not
            if(isPalindrome(prefix)){
                // if its palindrome put it into the data structure.
                ds.add(prefix);
                // make recursion call for the remaining string
                partition(ros , ds , res);
                // during backtrack, remove this string from data structure
                ds.remove(ds.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s){
        int i = 0 , j = s.length() - 1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--))return false;
        }
        return true;
    }
}

// Time Complexity: O( (2^n) *k*(n/2) )

// Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome. O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.

// Space Complexity: O(k * x)

// Reason: The space complexity can vary depending upon the length of the answer. k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).