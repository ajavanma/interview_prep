# Write a function that reverses a string. The input string is given as an array of characters s.
# You must do this by modifying the input array in-place with O(1) extra memory.

# Example 1:
# Input: s = ["h","e","l","l","o"]
# Output: ["o","l","l","e","h"]

from typing import List

class Solution:
    def reverseString(self, s: List[str]) -> None:
        left = 0 
        right = len(s) - 1
        
        while left < right:
            s[left], s[right] = s[right], s[left]
            
            left += 1
            right -= 1
