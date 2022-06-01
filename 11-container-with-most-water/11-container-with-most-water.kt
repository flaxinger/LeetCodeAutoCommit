class Solution {
    fun maxArea(height: IntArray): Int {
        var best = 0
        val N = height.size
        for(i in 0 until N){
            if((N-i)*height[i]>best){
                for(j in i+1 until N)
                    best = Math.max(best, (j-i)*Math.min(height[i], height[j]))
            }
        }
        return best
    }
}