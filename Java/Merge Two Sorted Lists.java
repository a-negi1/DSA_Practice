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

//naive approach
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        
        ListNode temp2 =list2;
        ArrayList <Integer> arr = new ArrayList<>();
        while(temp1!=null){
            arr.add(temp1.val);
            temp1=temp1.next;
        }

        while(temp2!=null){
            arr.add(temp2.val);
            temp2=temp2.next;
        }
         
       Collections.sort(arr);

       ListNode dummy = new ListNode(-1);
       ListNode curr= dummy;

       for(int i=0;i<arr.size();i++){
        curr.next = new ListNode(arr.get(i));
        curr = curr.next;
       }
        return dummy.next;

    }
}

//optimal approach 


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode a = new ListNode(-1);
        ListNode temp = a;
        while(temp1!=null && temp2!=null ){
           
            
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp = temp1;
                temp1=temp.next;
            }
            
            else{
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }
        if(temp1 != null){
            temp.next =temp1;
        }
        else{
            temp.next  =temp2;
        }
        return a.next;
    }
}