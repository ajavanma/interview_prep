package leetcode.hard.java;


// There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is
//  the minimum wage expectation for the ith worker.
// We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:
// Every worker in the paid group must be paid at least their minimum wage expectation.
// In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double 
//  that of another worker in the group, then they must be paid twice as much as the other worker.
// Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. 
// Answers within 10-5 of the actual answer will be accepted.


// Example 1:
// Input: quality = [10,20,5], wage = [70,50,30], k = 2
// Output: 105.00000
// Explanation: We pay 70 to 0th worker and 35 to 2nd worker.

// Example 2:
// Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
// Output: 30.66667
// Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.
 
// Constraints:
// n == quality.length == wage.length
// 1 <= k <= n <= 104
// 1 <= quality[i], wage[i] <= 104


import java.util.*;

// approach:
// Create an array of workers where each worker is represented by their quality, wage, and the wage-to-quality ratio.
// Sort this array based on the wage-to-quality ratio.
// Iterate through the sorted list and maintain a running total of the quality of the smallest k workers encountered using a max heap to 
//  easily remove the worker with the highest quality when needed.
// Compute the potential total wage for each group of k workers by multiplying the sum of their qualities by the current worker’s wage-to-quality
//  ratio (since it would be the maximum in this group due to the sorted order).
// We use a max heap to keep track of the highest qualities 

class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i], (double) wage[i] / quality[i]);
        }
        
        // (a, b) -> Double.compare(a.ratio, b.ratio): This is a lambda expression defining a comparator for two Worker objects, a and b.
        // Double.compare(a.ratio, b.ratio): This method compares two double values. It returns:
        // a negative integer if a.ratio is less than b.ratio
        // zero is equal
        // a positive integer if a.ratio is greater than b.ratio
        // This comparator is used by the sort method to arrange the workers from the lowest to the highest wage-to-quality ratio, 
        //  ensuring that we prioritize workers who are more cost-effective for the qualities they offer.
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio)); // sort the array of Worker objects based on their ratio 

        double minCost = Double.MAX_VALUE;
        int sumQ = 0;

        // initialize a PriorityQueue which functions as a max heap 
        // By maintaining a max heap of qualities, we can quickly access and remove the worker with the highest quality when we exceed the group size of k. 
        // This allows us to always keep the k workers with the smallest total quality, which minimizes the total cost when combined with the wage-to-quality ratio.
        //  Normally, a PriorityQueue in Java is a min heap, which means the smallest element comes to the front (root) 
        // and is ascending in order and the smallest element has priority (the first to be popped from the heap)
        // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            Worker worker = workers[i];
            sumQ += worker.quality;
            maxHeap.add(worker.quality);
            
            if (maxHeap.size() > k) {
                sumQ -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, sumQ * worker.ratio);
            }
        }
        
        return minCost;
    }
    
    class Worker {
        int quality;
        int wage;
        double ratio;
        
        Worker(int quality, int wage, double ratio) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = ratio;
        }
    }
}
