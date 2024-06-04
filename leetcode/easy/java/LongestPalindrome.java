package leetcode.easy.java;

// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

// Example 1:
// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

// Example 2:
// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.


import java.util.HashMap;

class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean oddCountFound = false;
        
        // Calculate the maximum length of the palindrome
        for (int count : countMap.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                oddCountFound = true;
            }
        }
        
        // If there's any character with an odd count, we can add one more character in the middle
        if (oddCountFound) {
            length += 1;
        }
        
        return length;
    }
}
