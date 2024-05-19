package java.sort;

public class SelectionSort {

   // time complexity: worst, average and best: O(n^2) ?
   // space complexity: O(1) (in-place sorting algorithm)
   // divide it into sorted and unsorted (implicitly)
   //
   // Sort by repeatedly finding the min in the unsorted array and swap it with the leftmost element
   // 
   public void sort(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n - 1; i++) {
         int min = i; // assume it is min and validate it by comparing with the rest, correct the min if found
         
         for (int j = i + 1; j < n; j++) { // compare, starting from the next one
            if (arr[j] < arr[min]) {
               min = j; // update the min value
            }
         }
         // swapping arr[min] and arr[i]
         int temp = arr[min];
         arr[min] = arr[i];
         arr[i] = temp;
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
      int[] arr = new int[] { 5, 1, 2, 9, 10 };
      SelectionSort ss = new SelectionSort();
      ss.printArray(arr);
      ss.sort(arr);
      ss.printArray(arr);
   }

}