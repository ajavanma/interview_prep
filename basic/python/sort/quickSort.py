# divide and conquer 

# number of times needed to divide the list in half is log n

# best and average case: O(n log n) time complexity
# worst case: O(n^2) time complexity like selection sort! if we always choose the worst pivot point 

# Space complexity: O(log n)  - because of the recursion stack


# first approach: in-place sorting
def quick_sort(nums, low, high):          # quick_sort(A, 0, len(A)-1)
    if low < high:                        # base case for recursion
        pi = partition(nums, low, high)   # rearranges the elements around a pivot and get the partition index (read i as pi)
        quick_sort(nums, low, pi - 1)     # Recursively sort the elements, before partition and after partition
        quick_sort(nums, pi + 1, high)

def partition(nums, low, high):
    pivot = nums[high]                   # arbitrarily set the pivot to the element at the index high (not max, but last)
    i = low                              # i keeps track of the end of the section where all elements are less than the pivot, start from the beginning

    for j in range(low, high):           # should: i < pivot < j
        if nums[j] < pivot:  
            nums[i], nums[j] = nums[j], nums[i]
            i += 1                       # expand the region of elements less than the pivot   

    nums[i], nums[high] = nums[high], nums[i] # Place the Pivot: After the loop, the pivot element at high is swapped with the element at i, placing the pivot in its correct position in the sorted array 
    
    return i                            # return the new position of the pivot, to guide the recursive sorting 


# second approach: temporarily uses extra space (O(n))
# pivot value: first item from the list, it could result in a worst case scenario if the list is already sorted reversely
def quick_sort(values):

  if len(values) <= 1:
    return values

  less_than_pivot = []
  greater_than_pivot = []
  pivot = values[0]
  # Then we loop through all the items in the list following the pivot.
  for value in values[1:]:
    if value <= pivot:
      less_than_pivot.append(value)
    else:
      greater_than_pivot.append(value)
  # recursive part
  return quick_sort(less_than_pivot) + [pivot] + quick_sort(greater_than_pivot)




