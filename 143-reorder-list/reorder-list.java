class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 1. Find length
        int l = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            l++;
        }

        // 2. Find end of first half
        ListNode firstEnd = head;

        for (int i = 1; i < (l + 1) / 2; i++) {
            firstEnd = firstEnd.next;
        }

        // 3. Split the list
        ListNode second = firstEnd.next;
        firstEnd.next = null;

        // 4. Reverse second half
        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 5. Merge alternatively
        ListNode f = head;
        ListNode s = prev;

        while (s != null) {

            ListNode fNext = f.next;
            ListNode sNext = s.next;

            f.next = s;
            s.next = fNext;

            f = fNext;
            s = sNext;
        }
    }
}