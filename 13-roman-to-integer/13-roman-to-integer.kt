class Solution {
    
    fun romanToInt(s: String): Int {
        var ans = 0
        val map = mutableMapOf<Char, Int>()    
        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000
        println(map)
        val arr = s.toCharArray()
        val N = arr.size-1
        for(i in 0..N ){
            if(i != N && map[arr[i]]!! < map[arr[i+1]]!!)
                ans-=map[arr[i]]!!
            else
                ans+=map[arr[i]]!!
        }
        return ans
    }
}