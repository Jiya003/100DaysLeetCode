/*
Question No. 234
Pallindrome Linked list

Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.

*/
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
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;            
        }

        ListNode prev=null;
        ListNode curr=slow;
        ListNode next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;          
        }
        ListNode start=head;
        while(prev!=null){
            if(prev.val!=start.val){
                return false;
            }
            prev=prev.next;
            start=start.next;
        }

        return true;

    }
}
