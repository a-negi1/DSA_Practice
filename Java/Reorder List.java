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

//brute force 
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode temp1 = head;
        
        while (temp1 != null && temp1.next != null && temp1.next.next != null) {
            ListNode temp2 = temp1;
            while (temp2.next.next != null) {
                temp2 = temp2.next;
            }
            
            ListNode lastNode = temp2.next;
            temp2.next = null;
            
            lastNode.next = temp1.next;
            temp1.next = lastNode;
            temp1 = temp1.next.next;
        }
    }
}

//optimal

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}