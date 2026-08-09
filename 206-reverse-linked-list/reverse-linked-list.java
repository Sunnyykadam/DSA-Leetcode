class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode pres = head;

        while (pres != null) {

            ListNode next = pres.next;

            pres.next = prev;
            prev = pres;
            pres = next;
        }

        return prev;
    }
}