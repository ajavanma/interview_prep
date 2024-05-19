package java.array;

public class MoveZeros {

   public void printArray(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public void arrayDemo() {
      int[] arr = { 8, 1, 0, 2, 1, 0, 3 };
      printArray(arr);
      moveZeros(arr, arr.length);
      printArray(arr);
   }

   public void moveZeros(int[] arr, int n) {
      // i and j are both indexes
      // j: focuses on "zero" elements (stays where it finds zero)
      int j = 0; 
      // i: focuses "non zero" elements
      for (int i = 0; i < n; i++) { 
         // is true if j has catched a zero but i not, then swap using temp
         if (arr[i] != 0 && arr[j] == 0) {
            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
         if (arr[j] != 0) {
            j++;
         }
      }
   }

   public static void main(String[] args) {
      MoveZeros arrUtil = new MoveZeros();
      arrUtil.arrayDemo();
   }

}