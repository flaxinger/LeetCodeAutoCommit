class Solution {
    
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ArrayList<Integer> arr;
    ArrayList<String> ans;
    int N;
    // Boolean[] visit = new Boolean[10];
    
    void trav(String s, Integer idx){
        
        if(idx == N){
            ans.add(s);
            return;
        }
        
        String buff = letters[arr.get(idx)];
        for(int i = 0; i < buff.length(); i++){
            trav(s+buff.charAt(i), idx+1);
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<String>();
        arr = new ArrayList<Integer>();
        

        for(int i = 0; i < digits.length(); i++){
            arr.add(digits.charAt(i)-'0'-2);
        }
        N = arr.size();
        if(N > 0) trav("", 0);
        
        return ans;
    }
}