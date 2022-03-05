// Problem Statement - Given an unlimited supply of coins of given denominations, find the minimum number of coins required to get the desired target.

/*
Approach - 1:

The idea is to use recursion to solve this problem. We recur to see if the total can be reached by including the coin or not for each coin of given denominations. If choosing the current coin resulted in the solution, update the minimum number of coins needed. Finally, return the minimum value we get after exhausting all combinations.

Following is the Java implementation of the idea:
 */

    // Function to find the minimum number of coins required
    // to get a total of `target` from set `S`
    public static int findMinCoins(int[] S, int target)
    {
        // if the total is 0, no coins are needed
        if (target == 0) {
            return 0;
        }
 
        // return infinity if total becomes negative
        if (target < 0) {
            return Integer.MAX_VALUE;
        }
 
        // initialize the minimum number of coins needed to infinity
        int coins = Integer.MAX_VALUE;
 
        // do for each coin
        for (int c: S)
        {
            // recur to see if total can be reached by including current coin `c`
            int result = findMinCoins(S, target - c);
 
            // update the minimum number of coins needed if choosing the current
            // coin resulted in a solution
            if (result != Integer.MAX_VALUE) {
                coins = Integer.min(coins, result + 1);
            }
        }
 
        // return the minimum number of coins needed
        return coins;
    }



/*
The time complexity of the above solution is exponential as each recursive call is making n recursive calls.

 
The problem has an optimal substructure as the problem can be broken down into smaller subproblems, which can further be broken down into yet smaller subproblems, and so on. The problem also clearly exhibits overlapping subproblems, so we will end up solving the same subproblem over and over again. The repeated subproblems can be seen by drawing a recursion tree for higher values of n. We know that problems having optimal substructure and overlapping subproblems can be solved by dynamic programming, in which subproblem solutions are saved rather than computed repeatedly.

In the method is demonstrated below in C++, Java, and Python, we use a bottom-up approach, i.e., we solve smaller subproblems first, then solve larger subproblems from them. It computes T[i] for each 1 <= i <= target, which stores the minimum number of coins needed to get a total of i. It makes use of smaller values of i already computed and has the same asymptotic runtime as Memoization but no recursion overhead.
 */

 // Approach 2 - DP

    // Function to find the minimum number of coins required
    // to get a total of `target` from set `S`
    public static int findMinCoins(int[] S, int target)
    {
        // `T[i]` stores the minimum number of coins needed to get a total of `i`
        int[] T = new int[target + 1];
        // There is no way that 0 rs can be paid
        T[0] = 0;
        for (int i = 1; i <= target; i++)
        {
            // initialize the minimum number of coins needed to infinity
            T[i] = Integer.MAX_VALUE;
            int result = Integer.MAX_VALUE;
 
            // do for each coin
            for (int c: S)
            {
                // check if the index doesn't become negative by including
                // current coin `c`
                if (i - c >= 0) {
                    result = T[i - c];
                }
 
                // if total can be reached by including current coin `c`,
                // update the minimum number of coins needed `T[i]`
                if (result != Integer.MAX_VALUE) {
                    T[i] = Integer.min(T[i], result + 1);
                }
            }
        }
 
        // `T[target]` stores the minimum number of coins needed to
        // get a total of `target`
        return T[target];
    }


    // The time complexity of the above solution is O(n.target), where n is the total number of coins and target is the total change required. The auxiliary space required by the program is O(target).