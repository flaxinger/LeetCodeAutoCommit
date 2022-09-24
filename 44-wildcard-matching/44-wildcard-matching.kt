class Solution {
       
    private val WILD = '*'
    private val QM = '?'
    private lateinit var vs: Array<BooleanArray>
    fun isMatch(s: String, p: String): Boolean {
        vs = Array(s.length+1){BooleanArray(p.length+1)}
        var pp = p
        while(pp.contains("**"))
          pp = pp.replace("**", "*")
        var count =0
        for(i in 0 until pp.length){
          if(pp[i]!=QM && pp[i] != WILD)
            count++
        }
        return _isMatch(s, pp, count);

    }
    fun _isMatch(s: String, p: String, left: Int): Boolean {
        
        if(vs[s.length][p.length]) return false
        vs[s.length][p.length] = true
        if(s.length < left) return false
        if(s.length == 0 || p.length == 0){
            if(p.length>0 && p[0] == WILD) 
                return _isMatch(s, p.substring(1), left)
            if(s.length != 0 || p.length!=0)
                return false
            else return true;
            
        }
        when(p[0]){
            WILD -> {
                if(p.length > 1){
                    when(p[1]){
                        WILD -> {
                            return _isMatch(s.substring(0), p.substring(1), left)
                        }
                        QM -> {
                            for(i in 0 until s.length){
                                if(_isMatch(s.substring(i), p.substring(1), left))
                                    return true
                            }
                            return false
                        }
                        else -> {
                            for(i in 0 until s.length){
                                if(s[i]==p[1] && _isMatch(s.substring(i), p.substring(1), left))
                                    return true
                            }
                            return false
                        }
                    }
                }
                else return true
            }
            QM ->{
                return _isMatch(s.substring(1), p.substring(1), left)
            }
            else -> {
                if(s[0]==p[0]){
                    return _isMatch(s.substring(1), p.substring(1), left-1)
                }
                else return false
            }
        }
        return false        
    }

}