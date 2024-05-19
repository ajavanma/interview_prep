package java.sort;

// time complexity:
//       average and worst  : O(n^2) 
//       best               : O(n) (when the array is already sorted)
//
// space complexity:
//       O(1) (in-place sorting algorithm)
//
// outer for-loop takes track of the "iteration" (based on the length -1)
// inner for-loop takes care of the "comparing and swapping"
//
// ascending
// Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. 
// If we haven’t done a swap in an iteration, break (the list is sorted)

public class BubbleSort {
   public void sort(int[] arr) {
      
      int n = arr.length;
      boolean isSwapped;

      for (int i = 1; i < n; i++) {
         isSwapped = false;
         for (int j = 0; j < n - i - 1; j++) { // in each iteration the last number is already sorted in its place
            if (arr[j] > arr[j + 1]) {
               // swap
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
               isSwapped = true;
            }
         }

         if (isSwapped == false) {  // after a complete "inner loop" pass, if no swap was done: it means the array is already sorted
            break;
         }
      }
   }

   public void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 5, 1, 2, 9, 10 };
      BubbleSort bs = new BubbleSort();
      bs.printArray(arr);
      bs.sort(arr);
      bs.printArray(arr);

   }

}
