package java.sort;

// efficient Divide and conquer
// time complexity: best and average: O(n log n)    [log n is because of the dividing the array and n because of the number of elements]
//                  worst: O(n^2)  [when the pivot is the smallest or largest element]
// space complexity: worst: O(n):  because the recursive call stack will store a pointer for each recursive call, and in the worst case of completely unbalanced partitions, there will be n recursive calls.
//                   best and average O(log n) since the partitioning is typically balanced, and there are O(log n) levels of recursion.
//                                              [log n is because of the recursion stack (lvl of recursion)]
// recursion
//
// takes an array and a range
// picks an element as pivot and partitions the given array around it
// Quick sort function, sorts the array from index 'low' to 'high'

public class QuickSort {
    public static void quickSort(int[] nums, int low, int high) {   // quickSort(nums, 0, nums.length - 1)
        if (low < high) {
            int pi = partition(nums, low, high); // Rearrange and get the partition index
            quickSort(nums, low, pi - 1);        // Recursively sort the elements before partition
            quickSort(nums, pi + 1, high);       // Recursively sort the elements after partition
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high]; // Arbitrarily set the pivot to the last element
        int i = low;            // i keeps track of the end of the section where all elements are less than the pivot
    
        for (int j = low; j < high; j++) { // Iterate over the range [low, high)
            if (nums[j] < pivot) {         // Check if current element is less than the pivot
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;                       // Expand the region of elements less than the pivot
            }
        }
    
        // Place the pivot in its correct position 
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;
    
        return i;                         // Return the new position of the pivot
    }
    

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // public static void main(String[] args) {
    //     int[] nums = {3, 6, 8, 10, 1, 2, 4}; 
    //     quickSort(nums, 0, nums.length - 1);
    //     System.out.println("Sorted array: ");
    //     for (int num : nums) {
    //         System.out.print(num + " ");
    //     }
    // }
}
