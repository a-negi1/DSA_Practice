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
    public ListNode swapPairs(ListNode head) {
        if(head==null ){
            return null;
        }
        ListNode res = null;
        ListNode prevleft = null;
        ListNode left = head;
        ListNode right;
        int size = 2;

        while(left!=null){
            
                right = left;
                for(int i=0;i<size-1;i++){
                    
                    if(right== null){
                        break;
                    }
                    else{
                        right = right.next;
                    }
                    
                }
                
                if(right!=null){
                    ListNode nextleft = right.next;
                    reverse(left,size);
                    if(prevleft !=null){
                        prevleft.next = right;
                    }
                    if(res==null){
                        res=right;
                    }
                    prevleft = left ;
                    left = nextleft;
                }
                else{
                    if(prevleft != null ){
                        prevleft.next = left;
                    }
                    if(res==null){
                        res=left;
                    }
                    break;
                    
                }

                
                
            
            

            
        }
        return res;
    }

    void reverse(ListNode he,int c){
        ListNode prev = null;
        ListNode curr = he;
        int size = c;

        while(size-- > 0 && curr != null){
            ListNode neww = curr.next;
            curr.next = prev;
            prev = curr;
            curr = neww;
        }
        
    }
}