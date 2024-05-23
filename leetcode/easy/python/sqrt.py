# Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
# Do not use any built-in exponent function or operator.

# Example :
# Input: x = 8
# Output: 2
# Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

# using a binary search algorithm 
class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        
        left, right = 1, x // 2
        
        while left <= right:
            mid = left + (right - left) // 2
            squared = mid * mid
            
            if squared == x:
                return mid
            elif squared < x:
                left = mid + 1
            else:
                right = mid - 1
                
        return right  # 'right' is the largest number whose square is less than or equal to x
