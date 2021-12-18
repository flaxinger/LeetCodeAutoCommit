class Trie {

    class Node{
        char val;
        ArrayList<Node> next;
        Node(){
            next = new ArrayList<>();
        }
        Node(char val){
            this.val = val;
            next = new ArrayList<>();
        }
    }
    
    Node head;
    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        insert(word+'F', head);
    }
    
    public void insert(String word, Node node){
        
        if(word.length()==0) return;
        for(Node n: node.next){
            if(n.val == word.charAt(0)){
                insert(word.substring(1, word.length()), n);
                return;
            }
        }
        node.next.add(new Node(word.charAt(0)));
        insert(word.substring(1, word.length()), node.next.get(node.next.size()-1));
        
    }
    public boolean search(String word) {
        return search(word+'F', head);
    }
    
    public boolean search(String word, Node node){
        
        if(word.length()==0)    return true;  
        for(Node n: node.next){
            if(n.val==word.charAt(0))
                return search(word.substring(1, word.length()), n);
        }
        return false;
    }
    
    
    public boolean startsWith(String prefix) {
        return search(prefix, head);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */