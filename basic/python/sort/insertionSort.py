
#  time complexity: worst and average: O(n^2)
#                                best: O(n) when the array is already sorted
#  space complexity: O(1) (in-place sorting algorithm)

# insights:
# In-Place: Only requires a constant amount of memory
# Online: Can sort a list as it receives it

def insertion_sort(nums):
    for i in range(1, len(nums)):
        j = i
        while j > 0 and nums[j-1] > nums[j]:
            # Swap 
            nums[j], nums[j-1] = nums[j-1], nums[j]
            j -= 1
    return nums
