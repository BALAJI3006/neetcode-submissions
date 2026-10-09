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
    public void reorderList(ListNode head) {
        ListNode mid=midNode(head);
        ListNode reverseHead = reverse(mid.next);
        mid.next=null;
        ListNode temp=new ListNode(-1);
        ListNode dummy=temp;
        while(head!=null && reverseHead!=null){
            temp.next=head;
            temp=temp.next;
            head=head.next;
            temp.next=reverseHead;
            reverseHead=reverseHead.next;
            temp=temp.next;
        }
        if(head!=null){
            temp.next=head;
        }
        if(reverseHead!=null){
            temp.next=reverseHead;
        }
    }
    public ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
