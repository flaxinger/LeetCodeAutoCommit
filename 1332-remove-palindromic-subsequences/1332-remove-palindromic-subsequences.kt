class Solution {
      
    fun removePalindromeSub(s: String): Int {
        if(s=="") return 0        
        var min = 2
        min = Math.min(min, removePalindromeSub(findAndRemovePalindrome(StringBuilder(s)))+1)
        return min
    }
    
    fun findAndRemovePalindrome(s: StringBuilder): String{
        var start = 0
        var end = s.length-1
        while(start<=end){
            if(s[start]==s[end]){
                if(start!=end){
                    s.deleteCharAt(end)
                    s.deleteCharAt(start)
                }
                else{
                    s.deleteCharAt(start)
                    end = s.length-1
                }
                end-=2
            }
            else{
                end--
            }
        }
        return s.toString()
    }
}