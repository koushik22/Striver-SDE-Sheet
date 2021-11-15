// Brute Force

/*
Brute force approach would be initialize an ans = 1.0, then looping through n times and each time multiply x with ans.
for n < 0,  at first we'll convert n to positive ans calculate ans in the same way. at last we need to return 1/ans. 

Edge Case: We know the range of integer is from -2147483648 to 2147483647. so if the n = -2147483648, then if we try to convert
n from negative to postive we'll get an overflow error. So, for safety we'll need to use a long variable.

TC - o(N), SC - o(1)
 */

 // Optimal Solution
 /*
 Suppose we need to calculate 2^10. We can write it as (2*2)^5 or (4)^5. Further (4)^5 can be written as 4*(4^4). Again
 4^4 can be written as (4*4)^2 or 16^2. Again 16^2 can be written as (16*16)^1 or (256)^1. Again 256^1 can be written as
 256 * (256^0). we know that anything to the power 0 will give us 1. So the algorithm is - 

 1. if n is even, multiply x eith itself and divide n by 2
 2. id n is odd, multilpy x with ans and decrement n by one.

## For more clarification do a dry run of 2^10.
 
  */

  class Solution {
    public double myPow(double x, int n) {
        // Take long to avoid overflow.
        long nn = n;
        if(nn < 0)nn = -1 * nn;
        double ans = 1.0;
        while(nn > 0){
            if(nn%2 == 0){
                x = x * x;
                nn = nn/2;
            }
            else{
                ans = ans * x;
                nn = nn-1;
            }
        }
        if(n < 0)ans = (double)1.0/(double)ans;
        return ans;
    }
}

// TC - o(NlogN), as we divide n by 2 each time.

