class Solution {
    
    
    int n;
    
    public boolean check(char[] a, char[] b){
        
        for(int i = 0;i < n; i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
    
    
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        n = p.length();
        int end = p.length();
        char[] test = p.toCharArray();
        Arrays.sort(test);
        char[] temp;
        while(end<=s.length()){
            temp = s.substring(end-n, end).toCharArray();
            Arrays.sort(temp);
            if(check(temp, test)){
                ans.add(end-n);
            }
            end++;
        }
        
        return ans;
    }
}