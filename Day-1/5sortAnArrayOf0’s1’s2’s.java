// Approach 1 - Simply sort the array. TC - O(nlogn)

// Aproach 2 - Using count sort. Count no of 0's, 1's & 2's. Then simply print no off 0's then no of 1's. Then no. of 2's.
// TC - O(2n). Two pass solution.
void sortColors(int A[], int n) {
    int num0 = 0, num1 = 0, num2 = 0;
    
    for(int i = 0; i < n; i++) {
        if (A[i] == 0) ++num0;
        else if (A[i] == 1) ++num1;
        else if (A[i] == 2) ++num2;
    }
    
    for(int i = 0; i < num0; ++i) A[i] = 0;
    for(int i = 0; i < num1; ++i) A[num0+i] = 1;
    for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
}
/*
Aproach 3(Dutch National Flag Algo)

    Problem Statement
Given an array containing only 0s, 1s and 2s, sort the array in place. Note that you should treat the numbers as objects, 
hence we can’t count 0s, 1s and 2s to recreate the array. Also you are not supposed to use the library’s sort function for
this problem.

Example 1
Input : 1 0 2 1 0

Output : 0 0 1 1 2

Example 2
Input : 2 2 0 1 2 0

Output : 0 0 1 2 2 2

Intuition:
The problem requires tracking the positions of 3 numbers only i.e the 0s, 1s and 2s. So we can track the smallest
number(in this case 0) using one pointer and the greatest number using another pointer(in this case 2). 
So we can proceed with the two pointer technique.

Basically, the main idea of this algorithm is to move the 0’s to extreme left and 2’s to the right of the array
respectively. Doing this, the 1’s automatically end up in the middle of the array. Thus, sorting the array at the
end. The algorithm mainly consists of these steps:

Solution
We can use a Two Pointers approach while iterating through the array. 
Let’s say the two pointers are called low and high which are pointing to the first and the last element of the 
array respectively. So while iterating, we will move all 0s before low and all 2s after high so that in the end,
all 1s will be between low and high.

    
*/

class Solution
{

  public void sortColors(int[] nums)
    {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (mid <= hi)
        {
            switch (nums[mid])
            {
            case 0:
                swap(nums[lo], nums[mid]);
                lo++;
                mid++;
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(nums[mid], nums[hi]);
                hi--;
                break;
            }
        }
    }
};