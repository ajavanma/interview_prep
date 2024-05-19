package java.array;

// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
// The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
// Increment the large integer by one and return the resulting array of digits.

class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {    // starting from extreme right--> if array[i] is less than 9 means can be added with 1
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // if array[i] is not less than 9, means it have to be 9 only then digit is changed to 0, and we again revolve around loop to check for number if less than 9 or not
        }
        // if all number inside array are 9: [ 9,9,9,9 ]-->[ 1,0,0,0,0 ] length: n-->n+1
        // thus just changed first value of array to 1 and return the array
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}