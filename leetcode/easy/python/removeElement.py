from typing import List

# Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
# The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        insertPosition = 0

        for num in nums:
            if num != val:
                nums[insertPosition] = num
                insertPosition += 1
        
        return insertPosition
