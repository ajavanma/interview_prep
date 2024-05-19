# direct merging into a new array: result array

# out-of-place merge: it creates a new array to hold the merged result
#  without modifying the originals
   
def merge_sorted_arrays(arr1, arr2):
    # tuple unpacking 
    n, m = len(arr1), len(arr2)
    
    # python lists are dynamic arrays
    result = [0] * (n + m)
    i, j, k = 0, 0, 0

    while i < n and j < m:
        if arr1[i] < arr2[j]:
            result[k] = arr1[i]
            i += 1
        else:
            result[k] = arr2[j]
            j += 1
        k += 1

    while i < n:
        result[k] = arr1[i]
        i += 1
        k += 1

    while j < m:
        result[k] = arr2[j]
        j += 1
        k += 1

    return result
