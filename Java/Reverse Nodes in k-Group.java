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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head== null){
            return null;
        }

        ListNode left = head;
        int size = k;
        ListNode right;
        ListNode res=null; 
        ListNode prevleft = null;
        while(left !=null){
           
                
                right = left;
            for (int i=0;i<size-1;i++){
                if(right == null){
                    break;}
                right=right.next;
            }
            
            
            

            if(right != null){
                ListNode nextleft =right.next;

                reverse(left,size);
                if(prevleft !=null){
                    prevleft.next =right;
                }
                if(res == null){
                    res = right;
                }
                prevleft = left;
                left = nextleft;
            }
            
           
        
        else{
            if(prevleft !=null){
                    prevleft.next =left;
                }
            if(res == null){
                res = left;
            }
            break;
        }
    }
        return res;
    }

    void reverse(ListNode head,int k){
        ListNode curr = head;
        ListNode prev = null;
        int size = k;
        while ( size>0 && curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            size--;
        }
    }
}