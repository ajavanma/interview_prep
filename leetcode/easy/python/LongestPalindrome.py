# Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
# Letters are case sensitive, for example, "Aa" is not considered a palindrome.

# Example 1:
# Input: s = "abccccdd"
# Output: 7
# Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

# Example 2:
# Input: s = "a"
# Output: 1
# Explanation: The longest palindrome that can be built is "a", whose length is 1.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = {}
        
        # Count the occurrences of each character
        for char in s:
            count[char] = count.get(char, 0) + 1
        
        length = 0
        odd_found = False
        
        # Calculate the maximum length of the palindrome
        for cnt in count.values():
            if cnt % 2 == 0:
                length += cnt
            else:
                length += cnt - 1
                odd_found = True
        
        # If there's any character with an odd count, we can add one more character in the middle
        if odd_found:
            length += 1
        
        return length
