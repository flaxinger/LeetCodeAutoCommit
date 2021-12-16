/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    

    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        map = new HashMap<>();
        
        Node cur = head;
        Node ans = new Node(head.val);
        Node ansCur = ans;
        while(cur.next!= null){
            map.put(cur, ansCur);
            ansCur.next = new Node(cur.next.val);
            ansCur = ansCur.next;
            cur = cur.next;
        }
        map.put(cur, ansCur);
        cur = head; ansCur = ans;
        while(cur != null){
            
            if(cur.random!=null)
                ansCur.random = map.get(cur.random);
            else
                ansCur.random = null;
            
            ansCur = ansCur.next;
            cur = cur.next;
        }
        return ans;
    }
}