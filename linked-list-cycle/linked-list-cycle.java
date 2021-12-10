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
    int INF = Integer.MAX_VALUE-1;
    public boolean hasCycle(ListNode head) {
        while(head!=null){
            if(head.val == INF) return true;
            head.val = INF;
            head = head.next;
        }
        return false;
    }
}