package leetcode.easy.java;

// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// approach:
// Each number in the triangle is the sum of the two numbers directly above it.
// Each row begins and ends with 1.
// Row i has i elements.

// time complexity is O(n2)

import java.util.List;
import java.util.ArrayList;

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();  // create a triangle list: list of lists of integers

        if (numRows == 0) return triangle; // return an empty list

        triangle.add(new ArrayList<>());  // up to this point the outer lists contains no inner lists
        triangle.get(0).add(1);   // .get(0).add(1) : The first row element is always 1, so add it manually

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1);  

            // Each triangle element (except the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);     // End the row with another 1

            triangle.add(row);
        }

        return triangle;
    }
}
