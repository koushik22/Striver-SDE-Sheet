// Naive Approach : 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == target)return true;
            }
        }
        return false;

// 2. Binary Search
/*

The problem statement states that the values of the last col of the ith row is greater than the first col of (i+1)th row. Also, each row is sorted.

This means that, if will linearly arrange the elements of each row, we will have a sorted array. So we can now perform a binary search over it.

How will the matrix behave like an array without actually creating an auxiliary array?

It could be achieved by the following formula →

A n * m matrix converted into an array: matrix[x][y] → a[x * m + y]

An array can be converted into n * m matrix: a[x] → matrix[x / m][x % m]

Solution Steps

Operate the matrix as an array using the above formula
Perform a binary search for the target element over the matrix
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int lo = 0 , hi = m*n - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int r = mid / n;
            int c = mid % n;
            
            if(matrix[r][c] < target){
                lo = mid + 1;
            }
            else if(matrix[r][c] > target){
                hi = mid - 1;
            }
            else{
                return true;
            }
        }
        
        return false;
    }
}
/*
Complexity Analysis

Time Complexity: O(log(m*n)) = O(log(m) + log(n))

Space Complexity: O(1)
 */

// 3. Optimal Solution(Remove row col in each comparison)

/*
1. Start from the top right corner: row = 0, col = m-1
2. if matrix[row][col] is equal target, return true.
3. if matrix[row][col] is less than the target, row = row + 1; indicates that this row can’t contain the target because this one in this line is the biggest one, counting from ‘row’.
4. if matrix[row][col] is greater than the target, col = col — 1; indicate that this column can’t contain the target because this one in this column is the smallest one, counting from ‘col’.
 */

 boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0)
        return false
    int n = matrix.length
    int m=matrix[0].length
    int row = 0,col = m-1
    while(row < n and col >= 0){
        if(matrix[row][col] == target)
            return true
        else if(matrix[row][col] < target)
            row = row + 1
        else 
            col = col - 1
    }
    return false
}
/*
Complexity Analysis

Time Complexity: O(m + n)

Space Complexity: O(1)
 */