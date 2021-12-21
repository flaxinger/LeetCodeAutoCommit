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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode cur;
        
        while(head!=null){
            arr.add(head);
            head=head.next;
        }
        
        for(int i = 0;i < arr.size(); i+=k){
            if(i+k <= arr.size()){
                cur = arr.get(i);
                for(int j = i+k-1; j>=i; j--){
                    arr.set(j, cur);
                    cur = cur.next;
                }
            } 
        }
        
        for(int i = 0;i < arr.size()-1; i++){
            arr.get(i).next = arr.get(i+1);
        }
        arr.get(arr.size()-1).next=null;
        return arr.get(0);
    }
}