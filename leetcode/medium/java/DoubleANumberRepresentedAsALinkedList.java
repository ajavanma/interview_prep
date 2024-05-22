package leetcode.medium.java;

// You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
// Return the head of the linked list after doubling it.

// Input: head = [1,8,9]
// Output: [3,7,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 189. 
// Hence, the returned linked list represents the number 189 * 2 = 378.

// Input: head = [9,9,9]
// Output: [1,9,9,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 999. 
// Hence, the returned linked list reprersents the number 999 * 2 = 1998. 

// recursive solution
// insights:
// while the recursion starts at the head, no processing (doubling) happens until the recursion reaches the base case and starts to return.
// This means we start from the head (most significant value) but the effective processing order reversed.
// from the least significant digit towards the most significant digit
// Each node's new value is only set during these return steps (not during the recursive calls)


public class DoubleANumberRepresentedAsALinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // To compute twice the value of each node's value and propagate the carry
    public int twiceOfVal(ListNode head) {
        if (head == null) return 0;
        
        // Double the value of current node and add the result of next nodes
        int doubledValue = head.val * 2 + twiceOfVal(head.next);
        
        // Update current node's value with the units digit of the result
        head.val = doubledValue % 10;
        
        // Return the carry (tens digit of the result)
        return doubledValue / 10;
    }
    
    public ListNode doubleIt(ListNode head) {
        int carry = twiceOfVal(head);
        
        // If there's a carry, insert a new node at the beginning with the carry value
        if (carry != 0) {
            head = new ListNode(carry, head);
        }
        
        return head;
    }
}