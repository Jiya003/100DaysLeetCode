/*
Question No. 61
Rotate List

Given the head of a linked list, rotate the list to the right by k places. 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

 

Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 109


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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode start=head;
        ListNode prev=head;
        int n=1;
        
        while(head.next!=null){
            head=head.next;
            n++;
        }        

        head.next=start;

        k=k%n;
        int count=n-k-1;
        for(int i=0;i<count;i++){
            start=start.next;
        }
        prev=start;
        start=start.next;
        prev.next=null;

        return start;
    }
}
