class Solution {
    
    val dx = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
    val dy = intArrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
    
    private class Node(
        val x: Int,
        val y: Int,
        val cost: Int
    )
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if(grid[0][0]!=0) return -1
        val queue: Queue<Node> = LinkedList()
        val N = grid.size
        queue.add(Node(0, 0, 1))
        var cur = queue.peek()
        val vs = Array(N){BooleanArray(N){true}}
        vs[0][0]=false
        var nx = 0
        var ny = 0
        while(queue.size>0){
            cur = queue.poll()
            if(cur.x == N-1 && cur.y == N-1)
                return cur.cost
            for(i in 0 until 8){
                nx = dx[i]+cur.x
                ny = dy[i]+cur.y
                if(nx >= 0 && nx < N && ny>=0 && ny < N && vs[nx][ny] && grid[nx][ny] == 0){
                    vs[nx][ny] = false
                    queue.add(Node(nx, ny, cur.cost+1))
                }
            }
        }
        return -1
    }
}