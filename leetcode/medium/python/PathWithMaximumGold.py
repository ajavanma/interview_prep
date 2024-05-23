from typing import List

class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        def dfs(x: int, y: int) -> int:
            # If the cell is out of bounds or contains no gold, return 0
            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == 0:
                return 0
            
            # Store the amount of gold in the current cell
            currentGold = grid[x][y]
            
            # Mark the current cell as visited by setting its value to 0
            grid[x][y] = 0
            
            # Explore all 4 directions: up, down, left, right
            up = dfs(x - 1, y)
            down = dfs(x + 1, y)
            left = dfs(x, y - 1)
            right = dfs(x, y + 1)
            
            # Restore the current cell's value
            grid[x][y] = currentGold
            
            # Return the maximum gold collected from the current cell
            return currentGold + max(up, down, left, right)
        
        maxGold = 0
        
        # Iterate through each cell in the grid
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                # If the cell contains gold, start a DFS from there
                if grid[i][j] > 0:
                    maxGold = max(maxGold, dfs(i, j))
        
        return maxGold
