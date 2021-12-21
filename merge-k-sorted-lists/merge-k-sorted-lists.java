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
    public ListNode mergeKLists(ListNode[] l) {
        
        int N = l.length, idx=0;
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode cur;
        boolean cont = true;
        arr.add(new ListNode(0));
        if(l.length ==0) return null;
        
        while(cont){
            cont = false;
            cur = new ListNode(Integer.MAX_VALUE);
            for(int i = 0;i < N; i++){
                if(l[i]!=null){
                    cont = true;
                    if(cur.val > l[i].val){
                        cur = l[i];
                        idx = i;
                    }
                }
            }
            if(cont && cur!=null){
                arr.get(arr.size()-1).next = new ListNode(cur.val);
                arr.add(arr.get(arr.size()-1).next);
                l[idx] = l[idx].next;
            }
        }
        if(arr.size() == 1) return null;
        return arr.get(1);
    }
}