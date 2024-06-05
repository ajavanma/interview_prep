from typing import List

# Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

# Example 1:
# Input: words = ["bella","label","roller"]
# Output: ["e","l","l"]

# Example 2:
# Input: words = ["cool","lock","cook"]
# Output: ["c","o"]

class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        min_freq = [float('inf')] * 26                  # Initialize with a high value (greater than any possible frequency)
        
        for word in words:
            char_count = [0] * 26                       # Initialize the frequency count for the current word
            for char in word:
                # The ord function returns the Unicode code point for a given character. For example, ord('a') returns 97, 
                # convert the character char into a zero-based index corresponding to its position in the alphabet.
                char_count[ord(char) - ord('a')] += 1   # For example, if char is 'a', ord('a') - ord('a') is 97 - 97, which is 0.

            # Update the minimum frequency array
            for i in range(26):
                min_freq[i] = min(min_freq[i], char_count[i])
        
        # Collect the result based on the minimum frequencies
        result = []
        for i in range(26):
            # The chr function returns the character corresponding to the specified Unicode code point.
            # ord('a') gives the Unicode code point for 'a', which is 97.
            result.extend([chr(i + ord('a'))] * min_freq[i])
        
        return result

# eg.
# min_freq = [1, 1, 0, ..., 2]  # This is an illustrative example

# This means:
# 'a' appears at least 1 time in all strings.
# 'b' appears at least 1 time in all strings.
# 'c' does not appear in all strings.
# 'z' appears at least 2 times in all strings.
