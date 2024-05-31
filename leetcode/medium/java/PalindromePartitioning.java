package leetcode.medium.java;

// public Given a string s, partition s such that every  substring of the partition is a  palindrome.
// Return all possible palindrome partitioning of s.
 
// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// Example 2:
// Input: s = "a"
// Output: [["a"]] 

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end));
                backtrack(s, end, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        right--; // adjust right to be inclusive
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning PalindromePartitioning = new PalindromePartitioning();
        System.out.println(PalindromePartitioning.partition("aab"));
        System.out.println(PalindromePartitioning.partition("a"));
    }
}
