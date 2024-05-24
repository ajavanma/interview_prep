package leetcode.easy.java;

// You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
// The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

// The 1st place athlete's rank is "Gold Medal".
// The 2nd place athlete's rank is "Silver Medal".
// The 3rd place athlete's rank is "Bronze Medal".
// For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
// Return an array answer of size n where answer[i] is the rank of the ith athlete.

// Example 1:
// Input: score = [5,4,3,2,1]
// Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
// Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].

// Example 2:
// Input: score = [10,3,8,9,4]
// Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
// Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

// insights:
// associating scores with indices and subsequently sorting by scores

import java.util.*;

// Custom Class ScoreIndex: This class holds the score and its original index, similar to a tuple in Python
class ScoreIndex {
    int score;
    int index;

    public ScoreIndex(int score, int index) {
        this.score = score;
        this.index = index;
    }
}

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        String[] ranks = new String[n];
       
        List<ScoreIndex> scoreWithIndex = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scoreWithIndex.add(new ScoreIndex(score[i], i));
        }

        // Sort in descending order using a custom comparator
        // A Comparator in Java is an interface used to define a custom ordering of objects in a collection.
        //  It is often used with sorting functions to dictate exactly how the objects should be compared and ordered. 
        // When you provide a comparator, you are essentially telling the sorting algorithm how to determine which of two objects comes first in the order.
        
        //  a comparator is defined using a lambda expression
        // (a, b):  parameters
        // b.score - a.score:  body of the lambda expression and defines how the comparison is performed
        // b.score - a.score:  sorts in descending order (if it is positive, then b comes first, if it is negative, then a comes first, if it is zero, then they are equal)
        scoreWithIndex.sort((a, b) -> b.score - a.score);

        // Assign ranks based on sorted list
        for (int i = 0; i < n; i++) {
            ScoreIndex si = scoreWithIndex.get(i);
            if (i == 0) {
                ranks[si.index] = "Gold Medal";
            } else if (i == 1) {
                ranks[si.index] = "Silver Medal";
            } else if (i == 2) {
                ranks[si.index] = "Bronze Medal";
            } else {
                ranks[si.index] = Integer.toString(i + 1);
            }
        }

        return ranks;
    }

    public static void main(String[] args) {
        RelativeRanks solution = new RelativeRanks();
        int[] scores = {5, 4, 3, 2, 1};
        String[] result = solution.findRelativeRanks(scores);
        for (String rank : result) {
            System.out.println(rank);
        }
    }
}






//// second approach:
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// public class RelativeRanks2 {
//     public String[] findRelativeRanks(int[] score) {
//         int n = score.length;
//         String[] ranks = new String[n];  // create a list that contains n empty strings (to store the ranks)
        
//         // store the score with its original index
//         // using HashMap for association and arrays for sorting
//         Map<Integer, Integer> scoreIndexMap = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             scoreIndexMap.put(score[i], i);
//         }
        
//         // Sort by scores in ascending order (then reverse it when assigning ranks)
//         Arrays.sort(score);
        
//         // Assign ranks based on sorted score positions
//         for (int i = 0; i < n; i++) {
//             int idx = scoreIndexMap.get(score[i]);
//             if (i == n - 1) { 
//                 ranks[idx] = "Gold Medal";
//             } else if (i == n - 2) { 
//                 ranks[idx] = "Silver Medal";
//             } else if (i == n - 3) { 
//                 ranks[idx] = "Bronze Medal";
//             } else { 
//                 ranks[idx] = Integer.toString(n - i);
//             }
//         }
        
//         return ranks;
//     }

//     public static void main(String[] args) {
//         RelativeRanks2 solution = new RelativeRanks2();
//         int[] scores = {10, 3, 8, 9, 4};
//         String[] result = solution.findRelativeRanks(scores);
//         for (String rank : result) {
//             System.out.println(rank);
//             // Gold Medal
//             // 5
//             // Bronze Medal
//             // Silver Medal
//             // 4
//         }
//     }
// }
