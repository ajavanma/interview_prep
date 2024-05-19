# only on sorted list
# time complexity: O(log n) 
# Divide and conquer

# Iterative Binary Search
def binary_search(list, target):
    low = 0
    high = len(list) - 1

    while low <= high:
        mid = low + (high - low) // 2   # Find the middle index using integer division, and avoid overflow
        
        if list[mid] == target:
            return mid            # Target found
        elif list[mid] < target:
            low = mid + 1         # Discard the left half
        else:
            high = mid - 1        # Discard the right half
            
    return None  # Target not found

 
# Recursive Binary Search
def recursive_binary_search(list, target):
    if len(list) == 0:
        return False
    else:
        mid = (len(list)) // 2
        if list[mid] == target:
            return True
        else:
            if list[mid] < target:
                return recursive_binary_search(list[mid+1:], target)
            else:
                return recursive_binary_search(list[:mid], target)
            
