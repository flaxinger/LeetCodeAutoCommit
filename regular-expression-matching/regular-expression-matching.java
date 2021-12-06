import java.util.*;

class Solution {
    
    String string;
    String pattern;
    
    public boolean isRegex(int patternIdx){
        return patternIdx+1 < pattern.length() && pattern.charAt(patternIdx+1) == '*';
    }
    
    public boolean match(int patternIdx, int stringIdx){
                
        if(stringIdx == string.length()){
            while(isRegex(patternIdx))
                patternIdx+=2;
        }
        if(patternIdx == pattern.length() && stringIdx == string.length()) return true;
        else if(patternIdx >= pattern.length() && stringIdx < string.length()) return false;
        else if(patternIdx < pattern.length() && stringIdx >= string.length()) return false;
        
        int max = Math.min(pattern.length()-patternIdx, string.length() - stringIdx);
        
        int pidx = 0, sidx = 0;
        for(int i = 0; i < max; i++){
            pidx = patternIdx+i;
            sidx = stringIdx+i;
            if(isRegex(pidx)){
                int tmpIdx = 0;
                if(match(pidx+2, sidx)) return true;
                while(tmpIdx+sidx < string.length() && (string.charAt(tmpIdx+sidx) == pattern.charAt(pidx) || pattern.charAt(pidx) == '.')){
                    if(match(pidx+2, tmpIdx+sidx+1)) return true;
                    tmpIdx++;
                }
            }
            else if(pattern.charAt(pidx) == '.' || pattern.charAt(pidx) == string.charAt(sidx)){
                if(match(pidx+1, sidx+1)) return true;
            }
            else return false;
        }
        return false;
    }
    
    
    public boolean isMatch(String s, String p) {

        string = s;
        pattern = p;
        
        
        return match(0, 0);
    }
}