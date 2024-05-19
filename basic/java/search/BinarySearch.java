package java.search;

// only for sorted array
//
// time complexity  : O(log n)
// space complexity : O(1)
//
// Divide and conquer

public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1; 
  
        while (low <= high) {
           int mid = low + (high - low) / 2; 
  
           if (arr[mid] == target) {
              return mid;   // target found, return index
           }

           if (target < arr[mid]) {
              high = mid - 1;
           } else {
              low = mid + 1;
           }
        }
        
        return -1;  // target not found
        // alternative: if we wanted to know where a target should be placed, we could return "low"
     }

     public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = { 1, 10, 20, 47, 59, 65, 75, 88, 99 };
        System.out.println(bs.binarySearch(arr, 65));
     }
    
}
