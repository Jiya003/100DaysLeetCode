/*
Question 203:
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode current=head;
        ListNode prev=null;

        while(head!=null && head.val==val){
            head=head.next;            
        }        

        current=head;

        while(current!=null){
            if(current.val==val){
                if(prev!=null)
                prev.next=current.next;
            }
            
            else{
                prev=current;
            }
            
            current=current.next;
        }

        return head;
    }
}
