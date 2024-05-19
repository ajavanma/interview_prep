package java.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayUtil {

   public void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public int findMinimum(int[] arr) {
      // edge case
      if (arr == null || arr.length == 0) {
         throw new IllegalArgumentException("Invalid input");
      }

      // suppose the first one is the minimum and check this
      int min = arr[0]; 
      for (int i = 1; i < arr.length; i++) {
         if (arr[i] < min) {
            min = arr[i];
         }
      }
      return min;
   }

   //reverse an array
   // swap start and end iteratively
   public void reverse(int[] arr, int start, int end) {
      while (start < end) {
         // swap
         int temp = arr[start];
         arr[start] = arr[end];
         arr[end] = temp;
         start++;
         end--;
      }
   }

   public static int[] twoSum(int[] numbers, int target) {
      int[] result = new int[2];
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < numbers.length; i++) {
         if (!map.containsKey(target - numbers[i])) {
            map.put(numbers[i], i);
         } else {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
         }
      }
      throw new IllegalArgumentException("Two numbers not found");
   }

   public static int[] twoSumII(int[] arr, int target) {
      // Sorting and Two Pointer
      Arrays.sort(arr); // 0 2 6 7 10 11
      int left = 0;
      int right = arr.length - 1;
      int[] result = new int[2];
      while (left < right) {
         int sum = arr[left] + arr[right];
         if (sum == target) {
            result[0] = arr[left];
            result[1] = arr[right];
            return result;
         } else if (sum < target) {
            left++;
         } else {
            right--;
         }
      }
      return new int[0];
   }

   public static int[] sortedSquares(int[] arr) {
      // Two pointer technique
      int n = arr.length;
      int i = 0;
      int j = n - 1;
      int[] result = new int[n];

      // {-4, -1, 0, 3} -> {0, 1, 9, 16}

      for (int k = n - 1; k >= 0; k--) {
         if (Math.abs(arr[i]) > Math.abs(arr[j])) {
            result[k] = arr[i] * arr[i];
            i++;
         } else {
            result[k] = arr[j] * arr[j];
            j--;
         }
      }
      return result;
   }

   // remove duplicates (in-place) in a sorted array
   // i: slow pointer (tracks the position where the next unique element should be)
   // j: fast pointer (scans through the array looking for the next unique element)
   public static int removeDuplicates(int[] arr) {
      if (arr.length == 0) return 0;

      int i = 0;
      for (int j = 1; j < arr.length; j++) {
         if (arr[j] != arr[i]) {
            i++;
            arr[i] = arr[j]; // store it in the next available position (was incremented in the last step)
         }
      }
      return i + 1; //  number of unique elements 
   }
    

   // gauss formula
   // we know the sum, iterate and subtract, the remaining is the missing number
   public static int findMissingNumber(int[] arr) {
      int n = arr.length + 1; // one number is missing
      int sum = n * (n + 1) / 2;
      for (int num : arr) { //  enhanced for loop (also known as the for-each loop); python equivalent for: for num in arr:
         sum = sum - num;
      }
      return sum;
   }

   public void arrayDemo() {
      int[] arr = { 1, 3, 6, 8, 2, 4, 7 };
      System.out.println(findMissingNumber(arr));
   }

   public static void main(String[] args) {
      ArrayUtil arrUtil = new ArrayUtil();
      arrUtil.arrayDemo();
   }

}