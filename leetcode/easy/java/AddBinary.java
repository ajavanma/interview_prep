package leetcode.easy.java;

// Given two binary strings a and b, return their sum as a binary string.

// Example 1:
// Input: a = "11", b = "1"
// Output: "100"

// Example 2:
// Input: a = "1010", b = "1011"
// Output: "10101"

// Constraints:
// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.

// First, we initialize a StringBuilder object to store the sum and two integer variables 'carry' and 'i' to keep track of the carry-over value and the current position in the first binary number (a), respectively.
// We also initialize another integer variable 'j' to keep track of the current position in the second binary number (b). Here is how the code initializes these variables:

class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
