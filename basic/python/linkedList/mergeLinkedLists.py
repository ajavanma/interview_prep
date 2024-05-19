# You are given the heads of two sorted linked lists list1 and list2.

# Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

# Return the head of the merged linked list.

class ListNode:
    def __init__(self, data=0, next=None):
        self.data = data
        self.next = next

class MergeLinkedLists:
    @staticmethod
    def merge(list1, list2):
    # def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # A dummy node to simplify the merging process
        dummy = ListNode(0)
        tail = dummy
        
        # Traverse as long as both lists have nodes
        while list1 is not None and list2 is not None:
            if list1.data <= list2.data:
                tail.next = list1
                list1 = list1.next
            else:
                tail.next = list2
                list2 = list2.next
            tail = tail.next
        
        # If any nodes remain in either list, append them
        tail.next = list1 if list1 is not None else list2
        
        # Return the head of the merged list, which follows the dummy node
        return dummy.next
