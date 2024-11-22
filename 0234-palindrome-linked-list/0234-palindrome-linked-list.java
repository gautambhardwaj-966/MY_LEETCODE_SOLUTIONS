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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = reverseList(slow);
        
        ListNode firstHalf = head;
        ListNode secondHalfCopy = secondHalf;
        boolean isPalindrome = true;
        
        while(secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        reverseList(secondHalfCopy);
        return isPalindrome;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev =current;
            current = next;   
        }
        return prev;
    }
}