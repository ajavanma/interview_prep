# Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

# Example 1:
# Input: c = 5
# Output: true
# Explanation: 1 * 1 + 2 * 2 = 5

# Example 2:
# Input: c = 3
# Output: false

class Solution(object):
    def judgeSquareSum(self, c):
        
        divisor = 2
        while divisor * divisor <= c:
            if c % divisor == 0:
                exponentCount = 0
                while c % divisor == 0:
                    exponentCount += 1
                    c //= divisor
                if divisor % 4 == 3 and exponentCount % 2 != 0:
                    return False
            
            divisor += 1
            
        return c % 4 != 3