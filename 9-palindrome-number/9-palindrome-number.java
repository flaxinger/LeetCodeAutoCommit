class Solution {
    public boolean isPalindrome(int x) {
        
        int n = x;
        int comp = 0;
        if(x < 0) return false;
        while(n > 0){
            comp = comp*10+n%10;
            n/=10;
        }
        if(comp == x) return true;
        return false;
        
    }
}