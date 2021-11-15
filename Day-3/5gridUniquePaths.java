// Brute Force

/*
We can try out all the paths using recursion. If we can reach to our destined position that is bottom right corner, we'll count
that path as a vaild path.
 */
// start location (0,0). Destination (m-1,n-1)
 class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePaths(0,0,m,n);
        
    }
    int uniquePaths(int i , int j , int m , int n){
        if(i == m-1 && j == n-1)return 1;
        if(i >= m || j >= n)return 0;
        return uniquePaths(i+1 , j , m , n) + 
                uniquePaths(i , j+1 , m , n);
    }
}

// TC of this code is exponential as it is calling its sub-problem several times. SC is also exponential due to multiple calls
// which will take place in the recursion stack.

// DP - Solution

/*
The time complexity of above recursive solution is exponential. There are many overlapping subproblems. We can draw a recursion tree for uniquePaths(3, 3) and see many overlapping subproblems. The recursion tree would be similar to Recursion tree for Longest Common Subsequence problem.

So this problem has both properties of a dynamic programming problem. Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array dp[][] in bottom up manner using the above recursive formula.
 */


 class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePaths(0,0,m,n ,dp);
        
    }
    int uniquePaths(int i , int j , int m , int n , int[][] dp){
        if(i == m-1 && j == n-1)return 1;
        if(i >= m || j >= n)return 0;
        //  If any sub-problem is already solved, we'll not recompute the result again rather than solving the subproblems again.
        if(dp[i][j] != 0)return dp[i][j];
        // Other wise we'll store the result of a sub problem in dp array.
        return dp[i][j] = uniquePaths(i+1 , j , m , n , dp) + 
                uniquePaths(i , j+1 , m , n , dp);
    }
}

// Optimal Solution using Combinatorics

/*
There is a mathematical approach to solving this problem.
Note that you have to take m + n - 2 steps in total. You have to take (m - 1) steps going down and (n-1) steps going right.
Let 0 denote a down step and 1 denote a right step.
So we need to find out the number of strings of length m + n - 2 which have exactly m - 1 zeroes and n - 1 ones.
Essentially we need to choose the positions of ‘1s’, and then ‘0s’ fall into the remaining positions.
So, the answer becomes Choose(m+n-2, n - 1).
 */

 class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = m - 1;
        double res = 1.0;
        // we need to find NcR
        
        for(int i=1;i<=r;i++){
            res = res * (N-r+i)/i;
        }
        
        return (int)res;
        
        
    }