# similar to bubble sort in that it works by repeatedly swapping items in a list.
# However, it's slightly more efficient than bubble sort because it only makes one swap per iteration.

def selection_sort(nums):
    n = len(nums)
    for i in range(n):
        min = i  # assume it is min and validate it
        for j in range(i+1, n):
            if nums[j] < nums[min]:
                min = j
        # Swap the found minimum element with the first element
        nums[i], nums[min] = nums[min], nums[i]
    return nums
