class Solution {
    private var C = 0
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        C = 0
        val map = mutableMapOf<String, Int>()
        for(w in words){
          C+=w.length
          if(map[w] == null)
            map[w] = 0
          map[w] = map[w]!!+1
        }
        var res = mutableListOf<Int>()
        for(i in 0..s.length-C){
          res.addAll(find(s, i, i, map))
        }
        return res.toSet().toList()
    }
    
    fun find(s: String, idx: Int, start: Int, words: MutableMap<String, Int>): MutableList<Int> {
      var tmp = ""
      if(idx-start == C)
        return mutableListOf(idx-C)
      
      val res = mutableListOf<Int>()
      val k = words.keys
      for(key in k){
        if(words[key]!!>0){
          if(s.startsWith(idx, key)){
            words[key] = words[key]!!-1
            res.addAll(find(s, idx+key.length, start, words))
            words[key] = words[key]!!+1
          }
        }
      }
      return res
    }
    
    
}

fun String.startsWith(idx: Int, s: String): Boolean{
  if(s.length>this.length-idx) return false
  for(i in 0 until s.length){
    if(this[i +idx]!=s[i]) return false
  }
  return true
}