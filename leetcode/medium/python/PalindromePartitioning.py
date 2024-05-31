# public Given a string s, partition s such that every  substring of the partition is a  palindrome.
# Return all possible palindrome partitioning of s.
 
# Example 1:
# Input: s = "aab"
# Output: [["a","a","b"],["aa","b"]]

# Example 2:
# Input: s = "a"
# Output: [["a"]] 

from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.backtrack(s, 0, [], result)
        return result

    def backtrack(self, s: str, start: int, currentList: List[str], result: List[List[str]]) -> None:
        if start == len(s):
            result.append(currentList.copy())
            return
        for end in range(start + 1, len(s) + 1):
            if self.isPalindrome(s, start, end):
                currentList.append(s[start:end])
                self.backtrack(s, end, currentList, result)
                currentList.pop()

    def isPalindrome(self, s: str, left: int, right: int) -> bool:
        right -= 1  # adjust right to be inclusive
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True

# Usage:
solution = Solution()
print(solution.partition("aab"))
print(solution.partition("a"))
