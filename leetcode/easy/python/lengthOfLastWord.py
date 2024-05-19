# Given a string s consisting of words and spaces, return the length of the last word in the string.
# * A word is a maximal substring consisting of non-space characters only.


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        words = s.strip().split()
        return len(words[-1])


# Strip any leading or trailing spaces, then split the string by whitespace
# Return the length of the last word in the list
