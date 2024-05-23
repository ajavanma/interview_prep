package leetcode.easy.java;

// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
// Do not use any built-in exponent function or operator.

// Example :
// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

// using a binary search algorithm 
class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;
        
        int start = 1;
        int end = x / 2;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long squared = mid * mid;
            
            if (squared == x) {
                return (int) mid;
            } else if (squared < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return (int) end; // 'end' is the largest number whose square is less than or equal to x
    }
}
