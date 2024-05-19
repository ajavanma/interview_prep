# Given two binary strings a and b, return their sum as a binary string.

# Example 1:
# Input: a = "11", b = "1"
# Output: "100"

# Example 2:
# Input: a = "1010", b = "1011"
# Output: "10101"

# Constraints:
# 1 <= a.length, b.length <= 104
# a and b consist only of '0' or '1' characters.
# Each string does not contain leading zeros except for the zero itself.

# It iterates over both strings from the end to the beginning. It adds the digits of a and b together with any carry from the previous addition. 
# The sum's digit (total % 2) is added to the result list, and the carry (total // 2) is calculated for the next iteration.
# After processing both strings and the carry, the result list is reversed to get the final binary sum in the correct order and joined into a string to return.

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        result = []
        carry = 0       # carry over value
        i = len(a) - 1  # current position in the first binary number (a) 
        j = len(b) - 1  # current position in the second binary number (b)
        
        # a while loop that iterates until we have processed all digits in both binary numbers and there is no more carry-over value left.
        # In each iteration, we add the digits from both numbers at the current position and the carry-over value (if any), and append the result to the StringBuilder object.
        # We also update the carry-over value based on the sum of the digits.
        
        # In each iteration, the current position in each binary number is moved one digit to the left (if there are any digits left to process) by decrementing the value of i and j.
        # If there is a carry-over value from the previous iteration or the addition of the two digits produces a carry-over value, we set the value of 'carry' to 1; otherwise, we set it to 0.
        # We also append the sum of the digits to the StringBuilder object by computing the remainder of 'carry' divided by 2 (which is either 0 or 1).
        # Finally, we update the value of 'carry' by dividing it by 2 (which gives either 0 or 1) so that we can carry over any remaining value to the next iteration.
        # After the while loop completes, we reverse the StringBuilder object and convert it to a string using the toString() method.
        # This gives us the sum of the two binary numbers in binary format. 
        while i >= 0 or j >= 0 or carry:
            total = carry
            if i >= 0:
                total += int(a[i])
                i -= 1
            if j >= 0:
                total += int(b[j])
                j -= 1
                
            carry = total // 2
            result.append(str(total % 2))
        
        return ''.join(reversed(result))
