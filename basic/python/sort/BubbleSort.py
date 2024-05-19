#
#  time complexity:
# average and worst  : O(n^2) 
# best               : O(n) (when the array is already sorted)
#
# space complexity: O(1) (in-place sorting algorithm)
#
# outer for-loop takes track of the "iteration" (based on the length -1)
# inner for-loop takes care of the "comparing and swapping"
#
# ascending
# Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. 
# If we haven’t done a swap in an iteration, break 
#

def bubble_sort(arr):
    
    n = len(arr)
    
    for i in range(1, n):
        swapped = False
        for j in range(n-i-1):
            if arr[j] > arr[j+1]: # Compare neighbors
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True
        if not swapped:
            break

# Example usage
arr = [64, 34, 25, 12, 22, 11, 90]
print(f"array is: \n {arr}")
bubble_sort(arr)
print(f"Sorted array is: \n {arr}")
