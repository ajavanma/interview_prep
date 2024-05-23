// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
package leetcode.easy.java;
import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // throw new IllegalArgumentException("No two sum solution");

        // Since the problem statement guarantees that a solution exists,
        // this line should never be executed. It is just here to replace the exception.
        System.out.println("No two sum solution found.");
        return new int[] {}; // Return an empty array if no solution is found.
    }
}
