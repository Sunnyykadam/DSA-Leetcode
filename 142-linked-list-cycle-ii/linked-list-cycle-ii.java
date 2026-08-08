/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length=0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                do{
                    length++;
                    slow=slow.next;
                }while(slow!=fast);
                break;
            }
        }
        ListNode f = head;
        ListNode s = head;
        if (length == 0) {
            return null;
        }
        while(length>0){
            s=s.next;
            length--;
        }
        while(f!=s){
            f=f.next;
            s=s.next;
        }
        return f;
        
    }
}