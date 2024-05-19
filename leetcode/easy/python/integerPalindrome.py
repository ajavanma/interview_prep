# Given an integer x, return true if x is a palindrome and false otherwise.

class Solution:
    def isPalindrome(self, x: int) -> bool:
        # Negative numbers are not palindromes
        if x < 0:
            return False

        # reverse the int
        original = x
        reversed = 0
        while x != 0:
            digit = x % 10
            reversed = reversed * 10 + digit
            x //= 10

        return original == reversed
