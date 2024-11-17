/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Method to get the length of a linked list
    private int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Method to find the intersection node
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int LenA = getListLength(headA);
        int LenB = getListLength(headB);

        // Adjust headA and headB to start at the same level
        while (LenA > LenB) {
            LenA--;
            headA = headA.next;
        }
        while (LenB > LenA) {
            LenB--;
            headB = headB.next;
        }

        // Traverse both lists to find the intersection
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA; // Returns the intersection node, or null if no intersection
    }
}
