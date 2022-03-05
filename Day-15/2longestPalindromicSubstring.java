// Approach 1 - Using Dynamic Programming



class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
        int ans_i = 0 , ans_j = 0;
        int len = 0;
        boolean[][] dp = new boolean[n][n];
        
        for(int g = 0; g < s.length(); g++){
            for(int i = 0, j = g; j < dp[0].length; i++ , j++){
                if(g == 0){
                    dp[i][j] = true;
                }
                else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j] == true && g+1 > len){
                    len = g+1;
                    ans_i = i;
                    ans_j = j;
                }
            }
        }
        return s.substring(ans_i , ans_j + 1);
    }
}


// Approach 2: Expand Around Center
// In fact, we could solve it in O(n^2) time using only constant space.

// We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n - 1 such centers.

// You might be asking why there are 2n - 1 but not n centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.


class Solution {
    public String longestPalindrome(String s) {
        
        int start = 0;
        int end = 0;
        
        for(int i = 0 ; i < s.length(); i++){
            int len1 = expandFromMiddle(s,i,i);
            int len2 = expandFromMiddle(s,i,i+1);
            
            int len = Math.max(len1 , len2);
            
            if(len > end - start){
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start , end + 1);
    }
    
    private int expandFromMiddle(String s , int left , int right){
        if(s == null || left > right)return 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}