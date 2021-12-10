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
        int v1=0,v2=0;
        int ten=1;
        while(head!=null)
        {
            v1=v1*10+head.val;
            v2=head.val*ten+v2;
            ten=ten*10;
            head=head.next;
        }
        return v1==v2;
    }
}