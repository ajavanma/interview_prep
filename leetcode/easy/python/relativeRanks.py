from typing import List


# You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
# The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

# The 1st place athlete's rank is "Gold Medal".
# The 2nd place athlete's rank is "Silver Medal".
# The 3rd place athlete's rank is "Bronze Medal".
# For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
# Return an array answer of size n where answer[i] is the rank of the ith athlete.

# Example 1:
# Input: score = [5,4,3,2,1]
# Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
# Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].

# Example 2:
# Input: score = [10,3,8,9,4]
# Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
# Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

# insights:
# associating scores with indices and subsequently sorting by scores

class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        
        n = len(score)
        ranks = [""] * n  # create a list that contains n empty strings (to store the ranks)
        
        # a list of tuples: store the score with its original index
        score_with_index = [(score[i], i) for i in range(n)]
        
        # Sort by score in descending order
        # lambda : sort() method uses the scores (first element of score, index tuple) to determine the order of elements in the list
        score_with_index.sort(reverse=True, key=lambda x: x[0])
        
        # Assign ranks based on sorted scores
        for i, (sc, idx) in enumerate(score_with_index):
            if i == 0:
                ranks[idx] = "Gold Medal"
            elif i == 1:
                ranks[idx] = "Silver Medal"
            elif i == 2:
                ranks[idx] = "Bronze Medal"
            else:
                ranks[idx] = str(i + 1)  # rank is zero-indexed, so add 1
        
        return ranks

# Example to test the class
if __name__ == "__main__":
    solution = Solution()
    scores = [10, 3, 8, 9, 4]
    print(solution.findRelativeRanks(scores))  # ['Gold Medal', '5', 'Bronze Medal', 'Silver Medal', '4']