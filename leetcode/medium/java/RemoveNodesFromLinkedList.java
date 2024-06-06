package leetcode.medium.java;
import java.util.Stack;

// You are given the head of a linked list.
// Remove every node which has a node with a greater value anywhere to the right side of it.
// Return the head of the modified linked list.

// Example 1:
// Input: head = [5,2,13,3,8]
// Output: [13,8]
// Explanation: The nodes that should be removed are 5, 2 and 3.
// - Node 13 is to the right of node 5.
// - Node 13 is to the right of node 2.
// - Node 8 is to the right of node 3.

// Example 2:
// Input: head = [1,1,1,1]
// Output: [1,1,1,1]
// Explanation: Every node has value 1, so no nodes are removed.

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the linked list
        ListNode reversedHead = reverseList(head);
        
        // Step 2: Remove nodes
        ListNode dummy = new ListNode(0);
        ListNode current = reversedHead;
        ListNode maxNode = dummy;
        
        while (current != null) {
            if (current.val >= maxNode.val) {
                maxNode.next = current;
                maxNode = current;
            }
            current = current.next;
        }
        
        maxNode.next = null; // Terminate the list
        
        // Step 3: Reverse the list again to restore the original order
        return reverseList(dummy.next);
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}



//second approach with stack: very slow
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Traverse the list and use the stack to filter nodes
        while (current != null) {
            while (!stack.isEmpty() && stack.peek().val < current.val) {
                stack.pop();
            }
            stack.push(current);
            current = current.next;
        }

        // reverses the order of nodes in a stack (restore the original order)
        ListNode nxt = null;
        while (!stack.isEmpty()) {
            current = stack.pop();
            current.next = nxt;    // The next pointer of the current node is updated to point to nxt
            nxt = current;         // updating for the next iteration (moving on)
        }
        
        return current;
    }
}
