// Method 1 - Brute Force
/* 
Traverse through the matrix and for any cell of mat[i][j] = 0, set its entire row to zero and its enitre column to zero.
We have marked these rows and cols of the corresponding cell to -1, so others zeros of that particular row and col can show
their effect.

TC - > O(n*m *(n + m)), S.C -> O(1)
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        
       kousik das
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j] == 0){
                        for(int r = 0; r < matrix.length;r++){
                            if(matrix[r][j] != 0)matrix[r][j] = -1;
                        }
                        
                        for(int c = 0; c < matrix[0].length;c++){
                            if(matrix[i][c] != 0)matrix[i][c] = -1;
                        }
                    }
                }
            }
        
        
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j] == -1)matrix[i][j] = 0;
                }
            }
            
        }
    }



    // Method 2 - Better Approach(Taking additional 2 arrays)

    /*
    Take two additional arrays namely 'rows' and 'cols'. iterate over the matrix and
    for any matrix[i][j] = 0, make rows[i] = 0 and cols[j] = 0. After that again iterate over the matrix
    for any matrix[i][j]. if(rows[i] == 0 || cols[j] == 0) set matrix[i][j] = 0.



    TC - > O(n*m + n*m), S.C -> O(n + m)
    
    
     */

    
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
            }
            
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                if(rows[i] == -1 || cols[j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}



// Method 3 - Optimal Solution

/*
We can use the first row and first column of the matrix to store the status of the rows and columns respectively. The problem will occur for the status of first row and column which can be handled using two variables which will store the status of the first row and column (Think!)

Solution Steps
1.Initialize firstRow and firstCol to false. These two variables will store the status of the first row and first column.
2.Now use the first row and first column as your hash which stores the status of that row and column.
3.Now iterate over the matrix and for every A[i][j] == 0, set A[i][0] = 0 and col[0][j] = 0.
4.Now update the values of the matrix except first row and first column to 0 if A[i][0] = true or A[0][i] = true for A[i][j].
5.Now update the values of the first row and first column.
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row0 = false , col0 = false;
        
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0)col0 = true;
            }
        
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0)row0 = true;
            }
        
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(col0 == true){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        
        if(row0 == true){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        
        
    }
}

 /*
 Complexity Analysis
Time Complexity: Checking the first row and first column + Traversing and updating the matrix + Updating first row and
 first column.

= O(M) + O(N) + O(M*N) + O(M) + O(N)

= O(M*N)

Space Complexity: O(1)

Critical ideas to think!
Why are the first row and first column updated separately?
Can you use other data structures to efficiently solve this problem?
 */