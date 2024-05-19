package java.linkedList;

// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.
public class mergeLinkedLists {
    // private ListNode head;

    private static class ListNode {
       private int data; 
       private ListNode next; 
 
       public ListNode(int data) {
          this.data = data;
          this.next = null;
       }
    }
    // given two sorted lists (a and b), merge them into a single sorted list
    public static ListNode merge(ListNode list1, ListNode list2) {
     // a dummy node to simplify edge cases and maintain a reference to the head of the new list
     // dummy is on the stack and is referencing a node in the Heap memory
     // tail is the reference we use to traverse (a or b, whichever is smaller in the current iteration)
     ListNode dummy = new ListNode(0);
     ListNode tail = dummy;
     // while none of the lists are exhausted
     // when one becomes empty, break from it, check which is empty, add the other one
     while (list1 != null && list2 != null) {
        if (list1.data <= list2.data) {
           // add to the dummy
           tail.next = list1;
           // one node of list1 is used, moving forward
           list1 = list1.next;
        } else {
           tail.next = list2;
           list2 = list2.next;
        }
        tail = tail.next;
     }
 
     if (list1 == null) {
        tail.next = list2;
     } else {
        tail.next = list1;
     }
     //dummy.next, which is the head of the merged list, skipping over the dummy node which was used just for simplification
     return dummy.next;
  }
 }