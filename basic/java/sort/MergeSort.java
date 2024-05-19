package java.sort;

public class MergeSort {

   // divide and conquer
   // divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves

   // time complexity: O(n log n)
   //    division: log n
   //    merging: n
   // space complexity: O(n)
   
   // a temporary array (temp) is used to store a copy of the elements from the original array
   //   that are currently being merged. After merging, the sorted elements are written back 
   //     into the original array arr in their correct positions.
   //    This method modifies the original array and uses the temp array to facilitate sorting.

   // in-place sort despite the use of the temp array (at the end the same arr is sorted)

   // "high" is length - 1
   public void sort(int[] arr, int[] temp, int low, int high) {
      if (low < high) {                    // base case of the recursion  
         int mid = low + (high - low) / 2; 
         sort(arr, temp, low, mid);        // left is from "low" to "mid"
         sort(arr, temp, mid + 1, high);   // right is from "mid + 1" to "high"
         merge(arr, temp, low, mid, high); // to distinct between the left and right arrays: "low" to "mid" and "mid + 1" to "high"
      }
   }
   // mid was calculated in the sort method
   private void merge(int[] arr, int[] temp, int low, int mid, int high) {
      for (int i = low; i <= high; i++) {
         temp[i] = arr[i];    // copy elements to temp array so that we don't overwrite it
      }                       // then use temp[i] and temp[j] to populate the arr[k]
   // this approach uses just one auxillary arr to be used as temp instead of making new lists in eah recursive call like the python approach

      int i = low;      // index to traverse left sorted sub-array
      int j = mid + 1;  // traverse right sorted sub-array
      int k = low;      // will merge both arrays into original array (arr) (in-place sort)

      // mid is the upper bound of the left sub-array
      // high is the upper bound of the right sub-array
      while (i <= mid && j <= high) {
         if (temp[i] <= temp[j]) {
            arr[k] = temp[i];     // fill the original array
            i++;
         } else {
            arr[k] = temp[j];     // the other way around
            j++;
         }
         k++;
      }

      // only if the right array is exhausted, we need some logic to handle the rest
      // if the left array is exhausted, the right array is already in the right place in the original array
      while (i <= mid) {
         arr[k] = temp[i];
         k++;
         i++;
      }
   }

   public void printArray(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      MergeSort ms = new MergeSort();

      // Test case 1: Simple array
      int[] arr1 = { 9, 5, 2, 4, 3, -1 };
      ms.sort(arr1, new int[arr1.length], 0, arr1.length - 1);
      ms.printArray(arr1); // Expected: -1 2 3 4 5 9

      // Test case 2: Array with duplicate elements
      int[] arr2 = { 5, 1, 5, 3, 5, 3, 4 };
      ms.sort(arr2, new int[arr2.length], 0, arr2.length - 1);
      ms.printArray(arr2); // Expected: 1 3 3 4 5 5 5

      // Test case 3: Already sorted array
      int[] arr3 = { 1, 2, 3, 4, 5, 6 };
      ms.sort(arr3, new int[arr3.length], 0, arr3.length - 1);
      ms.printArray(arr3); // Expected: 1 2 3 4 5 6

      // Test case 4: Reverse sorted array
      int[] arr4 = { 6, 5, 4, 3, 2, 1 };
      ms.sort(arr4, new int[arr4.length], 0, arr4.length - 1);
      ms.printArray(arr4); // Expected: 1 2 3 4 5 6

      // Test case 5: Array containing negative numbers
      int[] arr5 = { -3, -1, -7, -2, -5, 0 };
      ms.sort(arr5, new int[arr5.length], 0, arr5.length - 1);
      ms.printArray(arr5); // Expected: -7 -5 -3 -2 -1 0

      // Test case 6: Empty array
      int[] arr6 = {};
      ms.sort(arr6, new int[arr6.length], 0, arr6.length - 1);
      ms.printArray(arr6); // Expected: (nothing printed)
  }

}
