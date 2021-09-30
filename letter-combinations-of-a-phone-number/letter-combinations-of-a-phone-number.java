class Solution {
    
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ArrayList<Integer> arr;
    ArrayList<String> ans;
    // Boolean[] visit = new Boolean[10];
    
    void trav(String s, Integer idx){
        
        if(idx == arr.size()){
            ans.add(s);
            return;
        }
        String buff = letters[arr.get(idx)];
        System.out.printf("%d: %s", idx, buff);
        for(int i = 0; i < buff.length(); i++){
            trav(s+buff.charAt(i), idx+1);
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<String>();
        arr = new ArrayList<Integer>();


        for(int i = 0; i < digits.length(); i++){
            arr.add(digits.charAt(i)-'0'-2);
            // System.out.println(arr.get(i));
            // System.out.println(digits.charAt(i));
            // System.out.println(Integer.valueOf('2'));
        }
        
        if(arr.size() > 0) trav("", 0);
        
        return ans;
    }
}