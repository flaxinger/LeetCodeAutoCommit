/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    int lenA, lenB;
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp;
        lenA = 1;
        lenB = 1;
        tmp = headA;
        while(tmp.next!=null){
            tmp = tmp.next;
            lenA++;
        }
        tmp = headB;
        while(tmp.next!=null){
            tmp = tmp.next;
            lenB++;
        }
        
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        System.out.println(lenA+" "+ lenB);
        
        ListNode ans = null;
        while(lenA > 0){
            if(ans == null){
                // if(headA.val == headB.val) ans = headA;
                if(headA == headB)
                    return headA;
            }
            else if(headA.val != headB.val) ans = null;
            headA = headA.next;
            headB = headB.next;
            lenA--;
        }
        return ans;
    }
}