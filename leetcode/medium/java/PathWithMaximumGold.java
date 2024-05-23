package leetcode.medium.java;

// In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

// Return the maximum amount of gold you can collect under the conditions:

// Every time you are located in a cell you will collect all the gold in that cell.
// From your position, you can walk one step to the left, right, up, or down.
// You can't visit the same cell more than once.
// Never visit a cell with 0 gold.
// You can start and stop collecting gold from any position in the grid that has some gold.
 

// Example 1:

// Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
// Output: 24
// Explanation:
// [[0,6,0],
//  [5,8,7],
//  [0,9,0]]
// Path to get the maximum gold, 9 -> 8 -> 7.
// Example 2:

// Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
// Output: 28
// Explanation:
// [[1,0,7],
//  [2,0,6],
//  [3,4,5],
//  [0,3,0],
//  [9,0,20]]
// Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.

// approach: DFS search
// For each cell that contains gold, we start a DFS to explore all possible paths from that cell.
// In the dfs method, we check if the current cell is within bounds and contains gold. If not, we return 0.
// We store the amount of gold in the current cell and mark it as visited by setting its value to 0.
// We recursively explore all four possible directions (up, down, left, right) and collect the gold from those paths.
// After exploring, we restore the value of the current cell to allow for other paths that might use this cell.
// We return the total gold collected from the current cell plus the maximum gold collected from any of the four directions.

class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If the cell contains gold, start a DFS from there
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        
        return maxGold;
    }
    
    private int dfs(int[][] grid, int x, int y) {
        // If the cell is out of bounds or contains no gold, return 0
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        
        // Store the amount of gold in the current cell
        int currentGold = grid[x][y];
        
        // Mark the current cell as visited by setting its value to 0
        grid[x][y] = 0;
        
        // Explore all 4 directions: up, down, left, right
        int up = dfs(grid, x - 1, y);
        int down = dfs(grid, x + 1, y);
        int left = dfs(grid, x, y - 1);
        int right = dfs(grid, x, y + 1);
        
        // Restore the current cell's value
        grid[x][y] = currentGold;
        
        // Return the maximum gold collected from the current cell
        return currentGold + Math.max(Math.max(up, down), Math.max(left, right));
    }
}


