class Solution {
    
    var target = 0
    var best = Int.MAX_VALUE shr 1
    var N = 0
    
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        N = nums.size
        this.target = target
        
        find(nums, 0)
        return best+target
    }
    
    fun find(nums: IntArray, idx: Int){
        var sum = 0
        for(i in idx+1 until N){
            for(j in i+1 until N){
                if(i==j) continue
                sum = nums[idx]+nums[i]+nums[j]-target
                if(Math.abs(sum) < Math.abs(best)){
                    best = sum
                }
            }
        }
        if(idx < N-1){
            find(nums, idx+1)
        }
    }
    
}