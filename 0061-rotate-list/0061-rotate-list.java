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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }


        k = k % length;
        if (k == 0) {
            return head; 
        }


        tail.next = head;

        
        int stepsToNewHead = length - k;
        ListNode newTail = tail;
        while (stepsToNewHead > 0) {
            newTail = newTail.next;
            stepsToNewHead--;
        }
        ListNode newHead = newTail.next;

        
        newTail.next = null;

        return newHead;
    }
}