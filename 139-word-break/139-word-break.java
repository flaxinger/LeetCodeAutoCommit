class Solution {
    
    Map<String, Boolean> map;
    boolean[] poss;
    int N;
    
    public boolean dfs(String s){
        for(int i=s.length(); i>0; i--){
            if(map.getOrDefault(s.substring(0, i), false)){
                if(i==s.length()) return true;
                if(poss[N-s.length()+i] && dfs(s.substring(i,s.length()))) return true;
                else poss[N-s.length()+i] = false;
            }
        }
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        N = s.length();
        poss = new boolean[s.length()];
        Arrays.fill(poss, true);
        map = new HashMap<>();
        for(String st: wordDict){
            map.put(st, true);
        }
        
        return dfs(s);
    }
}