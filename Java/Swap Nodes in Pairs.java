class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;

        ListNode curr = start;

        while (curr.next != null && curr.next.next != null) {
            ListNode node1 = curr.next;
            ListNode node2 = node1.next;

            node1.next = node2.next;
            node2.next = node1;
            curr.next = node2;

            curr = node1;
        }

        return start.next;
    }
}