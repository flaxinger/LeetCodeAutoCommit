class Solution {
    String MAX = "+2147483647";
    String MIN = "-2147483648";
    
    public int myAtoi(String s) {
        s = refine(s);

        while(1 < s.length() && s.charAt(1) == '0'){
            s = s.substring(0,1)+s.substring(2);
        }
        
        if(s.length() == 0 || s.equals("+") || s.equals("-")) return 0;
        
        
        if(s.charAt(0) == '-'){
            if(s.length() > 11){
                return Integer.MIN_VALUE;
            }
            if(s.length() == 11){
                for(int i = 0; i < 11; i++){
                    if(MIN.charAt(i) != s.charAt(i)){
                        if(MIN.charAt(i) < s.charAt(i)) return Integer.MIN_VALUE;
                        else break;
                    }
                }   
            }
            return Integer.valueOf(s);
            
        }
        else{
            if(s.length() > 11){
                return Integer.MAX_VALUE;
            }
            if(s.length() == 11){
                for(int i = 0; i < 11; i++){
                    if(MAX.charAt(i) != s.charAt(i)){
                        if(MAX.charAt(i) < s.charAt(i)) return Integer.MAX_VALUE;
                        else break;
                    }
                }   
            }
            return Integer.valueOf(s);
        }

    }
    
    private String refine(String s){
        
        int idx = 0;
        StringBuilder result = new StringBuilder("");
        
        while(idx < s.length() && s.charAt(idx) == ' ') 
            idx++;
        if(idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')){
            result.append(s.charAt(idx));
            idx++;
        }
        if(result.length() == 0)
            result.append('+');
        while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9'){
            result.append(s.charAt(idx));
            idx++;
        }
        
        return result.toString();
    }
    
}