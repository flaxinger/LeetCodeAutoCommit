import java.util.*;

class Solution {
    
    String string;
    int idx = 0;
    String buildRep(){
        
        StringBuilder rep = new StringBuilder();
        StringBuilder i = new StringBuilder();
        while(string.charAt(idx)-'0' >=0 && string.charAt(idx)-'0'<=9){
            i.append(string.charAt(idx));
            idx++;
        }
        idx++;
        while(string.charAt(idx) !=']'){
            if(string.charAt(idx)-'0' >=0 && string.charAt(idx)-'0'<=9){
                rep.append(buildRep());
            }
            else{
                rep.append(string.charAt(idx));
            }
            idx++;
        }        
        // idx++;    
        // System.out.println(i+rep.toString());
        String addi = rep.toString();
        int ii = Integer.parseInt(i.toString());
        while(--ii>0){
            rep.append(addi);
            // System.out.println(addi);
        }
        return rep.toString();
    }
    
    
    public String decodeString(String s) {
        
        StringBuilder ans = new StringBuilder();
        string = s;

        char a, n;
        while(idx < s.length()){           
            if(s.charAt(idx)-'0' >=0 && s.charAt(idx)-'0'<=9){
                ans.append(buildRep());
            }
            else{
                ans.append(s.charAt(idx));
            }
            idx++;
            // System.out.println(ans);
        }
        return ans.toString();
    }
}