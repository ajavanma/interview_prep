package leetcode.easy.java;

// Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
// Return the positive integer k. If there is no such integer, return -1.

// Example 1:
// Input: nums = [-1,2,-3,3]
// Output: 3
// Explanation: 3 is the only valid k we can find in the array.

// Example 2:
// Input: nums = [-1,10,6,7,-7,1]
// Output: 7
// Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.

import java.util.HashSet;
import java.util.Set;

class LargestPositiveIntThanExistWithNegative {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxK = -1;
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int num : nums) {
            if (num > 0 && set.contains(-num)) {
                maxK = Math.max(maxK, num);
            }
        }
        
        return maxK;
    }
}
