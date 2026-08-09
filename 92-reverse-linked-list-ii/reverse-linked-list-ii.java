class Solution {
    public ListNode reverseBetween(ListNode head, int s, int e) {
        if (head == null || s == e) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;

        // Move to position s
        for (int i = 1; i < s; i++) {
            prev = current;
            current = current.next;
        }

        // Remember the connection before s
        ListNode beforeStart = prev;
        ListNode start = current;

        // Reverse from s to e
        for (int i = 0; i < e - s + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect the reversed part
        if (beforeStart != null) {
            beforeStart.next = prev;
        } else {
            head = prev;
        }

        start.next = current;

        return head;
    }
}