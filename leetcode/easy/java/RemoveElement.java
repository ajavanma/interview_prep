package leetcode.easy.java;

// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
// The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int insertPosition = 0;                     // a pointer for tracking the position to insert the next element that is not equal to val
        
        for (int num : nums) {
            if (num != val) {
                nums[insertPosition] = num;
                insertPosition++;
            }
        }
        
        return insertPosition;
    }
}
