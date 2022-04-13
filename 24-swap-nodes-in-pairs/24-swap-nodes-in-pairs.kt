/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        
        head?.let{ head ->
            val next = head.next
            next?.let{ next ->
                simpleSwap(head, next)
                if(next.next != null && next.next.next!=null)
                    head.next = swapPairs(next.next.next)  
                return next
            }
        }
        return head
    }
    
    fun simpleSwap(first: ListNode, second: ListNode){
        first.next = second.next
        second.next = first
    }
}