class Solution {
    
    var best = 0
    
    fun maxProduct(words: Array<String>): Int {
        var array = IntArray(words.size)
        for(i in 0 until words.size){
            for(c in words[i].toCharArray()){
                array[i] = array[i] or (1 shl (c-'a'))
            }
        }
        for(i in 0 until words.size){
            for(j in i until words.size){
                if((array[i] and array[j]) == 0)
                    best = Math.max(best, words[i].length * words[j].length)
            }
        }
        
        return best
    }
}