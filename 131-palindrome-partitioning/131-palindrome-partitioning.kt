/*
 * "aaa"의 경우
 * [["a", "a", "a"], ["aa", "a"], ["a", "aa"], ["aaa"]] 가 나와야함
 */
class Solution {
    
    val palindromeAtIndex = mutableMapOf<Int, MutableList<MutableList<String>>>()
    
    fun partition(s: String): List<List<String>> {
        val N = s.length
        for(i in 0 until N){
            palindromeAtIndex[i] = mutableListOf()
        }
        
        var start: Int
        var end: Int
        for(i in 0 until N){
            start = i
            end = i+1
            while(start>= 0 && end <= N){
                if(isPalindrome(s.substring(start, end))){
                    if(start>0){
                        for(found in palindromeAtIndex[start-1]!!){
                            palindromeAtIndex[end-1]?.add(mutableListOf())
                            palindromeAtIndex[end-1]?.last()?.addAll(found)
                            palindromeAtIndex[end-1]?.last()?.add(s.substring(start, end))
                        }
                    }
                    else{
                        palindromeAtIndex[end-1]?.add(mutableListOf(s.substring(start, end)))
                    }
                }
                start--
                end++
            }
            start = i
            end = i+2
            while(start>= 0 && end <= N){
                if(isPalindrome(s.substring(start, end))){
                    if(start>0){
                        for(found in palindromeAtIndex[start-1]!!){
                            palindromeAtIndex[end-1]?.add(mutableListOf())
                            palindromeAtIndex[end-1]?.last()?.addAll(found)
                            palindromeAtIndex[end-1]?.last()?.add(s.substring(start, end))
                        }
                    }
                    else{
                        palindromeAtIndex[end-1]?.add(mutableListOf(s.substring(start, end)))
                    }
                }
                start--
                end++
            }
        }
        
        return palindromeAtIndex[N-1]!!
    }
    
    private fun isPalindrome(word: String): Boolean{
        var start = 0
        var end = word.length-1
        while(start<end){
            if(word[start]!=word[end])
                return false
            start++
            end--
        }
        return true
    }
}