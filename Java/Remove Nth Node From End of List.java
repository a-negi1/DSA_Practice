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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        int length =0;
        int count =0;

        while(temp2!=null){
            length++;
            temp2 = temp2.next;
            
        }

        if(length == n){
            return head.next;
        }
        while(count != length-n-1 ){
            temp1 = temp1.next;
            count++;
        }

        temp1.next = temp1.next.next;
        
        return head;

    }
}