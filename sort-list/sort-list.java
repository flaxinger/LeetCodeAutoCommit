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
    
    // Quick Sort
    
    
    public void swap(ListNode node1, ListNode node2){
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
    
    public void sort(ListNode node, int count){
        // System.out.println(count);
        if(count <= 1) return;
        ListNode pivot = node;
        ListNode change = node;
        int change_count = 0, cnt=count;
        while(cnt > 1){
            node = node.next;
            if(node.val < pivot.val){
                change = change.next;
                swap(change, node);
                change_count++;
            }
            cnt--;
        }
        swap(change, pivot);
        sort(pivot, change_count);
        sort(change.next, count-change_count-1);
    }
    
    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        int cnt = 0;
        while(cur!=null){
            cur=cur.next;
            cnt++;
        }
        sort(head, cnt);
        return head;
    }
}