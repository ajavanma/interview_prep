package java.array;

// merge two sorted arrays in an array that is also sorted
// time complexity: O(n + m) 
// space complexity: O(n + m) 
// for space complexity we focus on the additional space required

public class MergeSortedArrays {

   // direct merging into a new array: result array
   
   // out-of-place merge: it creates a new array to hold the merged result
   //  without modifying the originals

   // n is length of arr1
   // m is length of arr2
   // public int[] merge(int[] arr1, int[] arr2, int n, int m) {

   public int[] merge(int[] arr1, int[] arr2) {

      int n = arr1.length, m = arr2.length;
      int[] result = new int[n + m];

      // i to traverse arr1
      int i = 0, j = 0, k = 0;
      // j to traverse arr2
      // int j = 0; 
      // k to traverse result
      // int k = 0; 

      // check them against each other, whichever is smaller, use it in the result, increment the index used
      // boundary conditions
      while (i < n && j < m) { 
         if (arr1[i] < arr2[j]) { 
            result[k] = arr1[i]; 
            // i is used, increment it
            i++;
         } else {
            result[k] = arr2[j];
            j++;
         }
         // either way inclement k
         k++;
      }

      // for the case if one array is exhausted
      //  put the rest of the other into the result
      // arr2 got exhausted first
      while (i < n) { 
         // storing rest of the arr1 elements into result array
         result[k] = arr1[i]; 
         i++;
         k++;
      }
      // arr1 got exhausted
      while (j < m) { 
         // storing arr2 element into result
         result[k] = arr2[j]; 
         j++;
         k++;
      }

      return result;

   }

   
   public void printArray(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      MergeSortedArrays msa = new MergeSortedArrays();
      int[] arr1 = { 0, 1, 8, 10 };
      int[] arr2 = { 2, 4, 11, 15, 20 };
      msa.printArray(arr1);
      msa.printArray(arr2);

      int[] result = msa.merge(arr1, arr2);
      msa.printArray(result);
   }

}