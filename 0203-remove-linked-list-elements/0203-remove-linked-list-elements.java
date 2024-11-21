/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Remove nodes from the start of the list that match the value
        while (head != null && head.val == val) {
            head = head.next; // Move head to the next node
        }

        // If the list is now empty, return null
        if (head == null) {
            return null;
        }

        // Traverse the list and remove nodes that match the value
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // Skip the node with the matching value
            } else {
                current = current.next; // Move to the next node
            }
        }

        return head;
    }
}