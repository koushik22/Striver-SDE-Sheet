// Problem Statement : Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N – 1, N – 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are ‘U'(up), ‘D'(down), ‘L’ (left), ‘R’ (right). Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.

// Solution 1: Recursion

// Intuition:

// The best way to solve such problems is using recursion.

// Approach:

// Start at the source(0,0) with an empty string and try every possible path i.e upwards(U), downwards(D), leftwards(L) and rightwards(R).

// As the answer should be in lexicographical order so it’s better to try the directions in lexicographical order i.e (D,L,R,U)

// Declare a 2D-array named visited because the question states that a single cell should be included only once in the path,so it’s important to keep track of the visited cells in a particular path.

// If a cell is in path, mark it in the visited array.

// Also keep a check of the “out of bound” conditions while going in a particular direction in the matrix. 

// Whenever you reach the destination(n,n) it’s very important to get back as shown in the recursion tree.

// While getting back, keep on unmarking the visited array for the respective direction.Also check whether there is a different path possible while getting back and if yes, then mark that cell in the visited array.



class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        findPath(0 , 0 , m , n , "" , res , visited);
        return res;
    }
    
    static void findPath(int i , int j , int[][] m , int n , String psf , 
        ArrayList<String> res , boolean[][] visited){
            // smarts base cases
        if(i < 0 || j < 0 || i >= n || j >= n || visited[i][j] == true || m[i][j] == 0)return;
        
        // if reached at last cell, store "psf" in res
        if(i == n - 1 && j == n - 1){
            res.add(psf);
            return;
        }

        // if visited for the first time, mark this cell visited
        visited[i][j] = true;
        // try out all the possible paths
        findPath(i + 1 , j , m , n , psf + "D" , res , visited);
        findPath(i , j - 1 , m , n , psf + "L" , res , visited);
        findPath(i , j + 1, m , n , psf + "R" , res , visited);
        findPath(i - 1 , j , m , n , psf + "U" , res , visited);
        // during backtrack mark "unvisited" the current cell
        visited[i][j] = false;
    }
}

// Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.

// Space Complexity:  O(m*n) ,Maximum Depth of the recursion tree(auxiliary space).