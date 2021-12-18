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
    
    static final int VS = 1000000;
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        while(head.next!=null){
            if(head.val == VS)
                return head;
            head.val = VS;
            head = head.next;
        }
        return null;
    }
}