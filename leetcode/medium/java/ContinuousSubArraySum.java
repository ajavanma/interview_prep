package leetcode.medium.java;

// Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
// A good subarray is a subarray where:
// its length is at least two, and the sum of the elements of the subarray is a multiple of k.

// Note that:
// A subarray is a contiguous part of the array.
// An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 
// Example 1:
// Input: nums = [23,2,4,6,7], k = 6
// Output: true
// Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

// Example 2:
// Input: nums = [23,2,6,4,7], k = 6
// Output: true
// Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
// 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

// Example 3:
// Input: nums = [23,2,6,4,7], k = 13
// Output: false

import java.util.HashMap;

class ContinuousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Handle the edge case where k is 0
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        // HashMap to store the remainder of the cumulative sum and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Initialize with 0 to handle the case when the subarray starts from index 0

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            // In case the remainder is negative, adjust it to be positive
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {  // Check if the subarray length is at least 2
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        
        return false;
    }
}
