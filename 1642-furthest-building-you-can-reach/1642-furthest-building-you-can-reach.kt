class Solution {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        
        var b = bricks
        val pq = PriorityQueue<Int>{a, b -> 
            a.compareTo(b)
        }
        
        var i = 0
        while(++i < heights.size){
            if(heights[i]>heights[i-1]){
                val cur = heights[i]-heights[i-1]
                if(pq.size < ladders){
                    pq.add(cur)
                }
                else if(ladders>0 && pq.peek()<cur){
                    b-=pq.poll()
                    pq.add(cur)
                }
                else
                    b-=cur
                
                if(b<0)
                    return i-1
            }
                
        }
        return heights.size-1
    }
}