# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

from typing import Optional

class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Helper function to reverse the linked list
        def reverseList(head: Optional[ListNode]) -> Optional[ListNode]:
            prev = None
            current = head
            while current:
                next_node = current.next
                current.next = prev
                prev = current
                current = next_node
            return prev
        
        # Step 1: Reverse the linked list
        reversed_head = reverseList(head)
        
        # Step 2: Traverse the reversed list and remove nodes
        dummy = ListNode(0)
        max_node = dummy
        current = reversed_head
        
        while current:
            if current.val >= max_node.val:
                max_node.next = current
                max_node = current
            current = current.next
        
        max_node.next = None  # Terminate the list
        
        # Step 3: Reverse the list again to restore the original order
        return reverseList(dummy.next)
