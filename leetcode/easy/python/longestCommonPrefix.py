# Write a function to find the longest common prefix string amongst an array of strings.
# If there is no common prefix, return an empty string "".

class Solution:
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""

        prefix = strs[0]
        for i in range(1, len(strs)):
            while strs[i].find(prefix) != 0:
                # Shorten the prefix by one character from the end
                prefix = prefix[:len(prefix) - 1]
                if not prefix:
                    return ""
        return prefix
