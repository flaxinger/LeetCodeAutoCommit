class Solution {
      
    fun removePalindromeSub(s: String): Int {
        if(findAndRemovePalindrome(StringBuilder(s)) == "") return 1
        return 2
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