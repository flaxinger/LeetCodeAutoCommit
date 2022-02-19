import java.math.*;

class Solution {
    BigInteger MAX = new BigInteger("+2147483647");
    BigInteger MIN = new BigInteger("-2147483648");
    
    public int myAtoi(String s) {
        
        s = refine(s);
        
        while(1 < s.length() && s.charAt(1) == '0'){
            s = s.substring(0,1)+s.substring(2);
        }
        if(s.length() == 0 || s.equals("+") || s.equals("-")) return 0;
        
        BigInteger num = new BigInteger(s);
        
        if(num.compareTo(BigInteger.ZERO)< 0){
            if(num.compareTo(MIN) < 0)
                return MIN.intValue();
            return num.intValue();
        }
        else{
            if(num.compareTo(MAX) > 0){
                return MAX.intValue();
            }
            return num.intValue();
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