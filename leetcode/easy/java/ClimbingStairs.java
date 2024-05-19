package leetcode.easy.java;

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Essentially, the number of ways to reach the current step is the sum of the ways to reach the previous step and the step before that,
//   because from each of those steps, you can reach the current step by taking one or two steps respectively.


class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] ways = new int[n + 1];    // An array to store the number of ways to climb to each step, with indices corresponding to the number of steps.
        ways[1] = 1;                    // ways[i] is the number of ways to reach step i.
        ways[2] = 2;                    // base cases
        
        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        
        return ways[n];
    }
}
