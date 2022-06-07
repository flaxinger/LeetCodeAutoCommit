class Solution {
    
    var map = mutableMapOf<Int, Int>()
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        for(candidate in candidates){
            if(!map.contains(candidate)){
                map[candidate] = 1
            }
            else{
                map[candidate] = map[candidate]!!+1
            }
        }
        return find(0, map.keys.toIntArray().sortedArray(), target).map{it -> it.toList()}.toList()
    }
    
    fun find(idx: Int, candidates: IntArray, target: Int): MutableSet<MutableList<Int>>{
        val ans = mutableSetOf<MutableList<Int>>()
        if(target == 0){
            ans.add(mutableListOf())
            return ans
        }
        if(idx== candidates.size) return ans
        if(candidates[idx] == target){
            ans.add(mutableListOf(candidates[idx]))
            return ans
        }
        
        val skip = find(idx+1, candidates, target)
        for(s in skip){
            ans.add(s)
        }
        
        var sum = 0
        repeat(map[candidates[idx]]!!){
            sum+=candidates[idx]
            if(target-sum>=0){
                val take = find(idx+1, candidates, target-sum)
                for(t in take){
                    repeat(sum/candidates[idx]){
                        t.add(candidates[idx])
                    }
                    ans.add(t)
                }
            }
        }
        
        return ans
    }
}