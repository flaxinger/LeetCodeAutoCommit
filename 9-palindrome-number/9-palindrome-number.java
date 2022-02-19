class Solution {
    public boolean isPalindrome(int x) {
        
        String string = String.valueOf(x);
        int s = 0;
        int e = string.length()-1;
        
        while(e >= 0 && s <= e && string.charAt(s) == string.charAt(e)){
            s++;
            e--;
        }
        if(s<=e)
            return false;
        return true;
    }
}