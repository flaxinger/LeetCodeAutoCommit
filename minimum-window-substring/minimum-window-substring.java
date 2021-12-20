class Solution {
    
    
    Map<Character, Integer> map;
    
    public String minWindow(String s, String t) {
                map = new HashMap<>();
        
        int left = 0;
        
        for(char c: t.toCharArray()){
            map.putIfAbsent(c, 0);
            map.compute(c, (k, v)-> v+1);
            left++;
        }
        
        int start = 0, end = 0, N = s.length();
        String ans="";
        char c;
        while(end<N){
            while(left>0&&end < N){
                c = s.charAt(end);
                if(map.getOrDefault(c, -1)>0){
                    left--;
                    map.compute(c, (k, v)->v-1);
                }
                else map.computeIfPresent(c, (k, v)->v-1);
                end++;
            }
            while(start < end){
                c = s.charAt(start);
                map.computeIfPresent(c, (k, v)->v+1);
                if(map.getOrDefault(c, -1)>0){
                    if(left == 0){
                        if(ans=="" || ans.length() > end-start)
                            ans=s.substring(start, end);
                    }
                    start++;
                    left++;
                    break;
                }
                start++;
            }
            
        }
        return ans;
    }
    

}