package java.sort;

// time complexity: worst and average: O(n^2)
//                               best: O(n) when the array is already sorted
// space complexity: O(1) (in-place sorting algorithm)

// insights:
// In-Place: Only requires a constant amount of memory
// Online: Can sort a list as it receives it

public class InsertionSort {
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j-1] > nums[j]) {
                // Swap 
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 3, 1, 5, 13, 12};
        insertionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
