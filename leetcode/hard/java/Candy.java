package leetcode.hard.java;

// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        
        // forward pass: right child gets more candies if it has a higher rating
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // backward pass: left child gets more candies if it has a higher rating
        for (int i = n - 2; i >= 0; i--) {     // from second-last to the first
            if (ratings[i] > ratings[i + 1]) {
                // maximum between its current number of candies and one more than the right neighbor's candies. 
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);  

            }
        }
        
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
}