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
    public boolean isPalindrome(ListNode head) {
        int l = 0;
        ListNode temp = head;
        ListNode temp1 = head;
        while(temp!=null){
            temp=temp.next;
            l++;
        }
        for(int i=0;i<l/2;i++){
           temp1=temp1.next;
        }
        ListNode prev = null;
        ListNode curr = temp1;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode f = head;
        ListNode s = prev;
        while(s!=null){
            if(s.val==f.val){
                s=s.next;
                f=f.next;
            }else{
                return false;
            }
        }
        return true;
    }
}