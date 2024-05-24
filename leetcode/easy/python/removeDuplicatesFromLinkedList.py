from typing import Optional

class Solution:
    class ListNode:
        def __init__(self, val=0, next=None):
            self.val = val
            self.next = next


    # Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
    # def deleteDuplicates(self, head):
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Check if the list is empty or has only one node
        if head is None or head.next is None:
            return head

        # Pointer to traverse the list
        current = head

        while current.next:
            # If the current value is equal to the next value, skip the next node
            if current.data == current.next.data:
                current.next = current.next.next
            else:
                # Move to the next node
                current = current.next

        return head
