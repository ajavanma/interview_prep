# Given an integer numRows, return the first numRows of Pascal's triangle.
# In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

# Example 1:
# Input: numRows = 5
# Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

# approach:
# Each number in the triangle is the sum of the two numbers directly above it.
# Each row begins and ends with 1.
# Row i has i elements.

# time complexity is O(n2)


from typing import List

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        triangle = []

        if numRows == 0:
            return triangle

        triangle.append([1])    # First row is always [1]

        for rowNum in range(1, numRows):
            row = [1]       # Start the row with [1]
            
            prevRow = triangle[rowNum - 1]   # Previous row from which we'll derive this row's values
            for j in range(1, rowNum):
                row.append(prevRow[j - 1] + prevRow[j])   # Generate the middle values of the row
            
            row.append(1)   # End the row with another 1
            triangle.append(row)   
        
        return triangle
