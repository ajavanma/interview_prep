package leetcode.easy.java;

// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.
 

// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Example 3:
// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        // Normalizing the string: lowercase and remove non-alphanumeric characters
        String filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int left = 0, right = filtered.length() - 1;
        while (left < right) {
            if (filtered.charAt(left) != filtered.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        return true; 
    }
}
