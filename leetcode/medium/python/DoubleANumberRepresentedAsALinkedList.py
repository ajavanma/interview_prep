from typing import Optional
# You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
# Return the head of the linked list after doubling it.

# Input: head = [1,8,9]
# Output: [3,7,8]
# Explanation: The figure above corresponds to the given linked list which represents the number 189. 
# Hence, the returned linked list represents the number 189 * 2 = 378.

# Input: head = [9,9,9]
# Output: [1,9,9,8]
# Explanation: The figure above corresponds to the given linked list which represents the number 999. 
# Hence, the returned linked list reprersents the number 999 * 2 = 1998. 

# recursive solution
# insights:
# while the recursion starts at the head, no processing (doubling) happens until the recursion reaches the base case and starts to return.
# This means we start from the head (most significant value) but the effective processing order reversed.
# from the least significant digit towards the most significant digit
# Each node's new value is only set during these return steps (not during the recursive calls)

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # To compute twice the value of each node's value and propagate carry
    def twice_of_val(self, head: Optional[ListNode]) -> int:
        if not head:
            return 0
        
        # Double the value of current node and add the result of next nodes
        doubled_value = head.val * 2 + self.twice_of_val(head.next)
        
        # Update current node's value with the units digit of the result
        head.val = doubled_value % 10
        
        # Return the carry (tens digit of the result)
        return doubled_value // 10
    
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        carry = self.twice_of_val(head)
        
        # If there's a carry, insert a new node at the beginning with the carry value
        if carry:
            head = ListNode(carry, head)
        
        # Return the head of the updated linked list
        return head