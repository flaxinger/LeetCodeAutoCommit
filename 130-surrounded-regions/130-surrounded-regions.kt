class Solution {
    
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    fun solve(board: Array<CharArray>): Unit {
        val vs = Array(board.size){BooleanArray(board[0].size){true}}
        for(i in 0 until board.size){
            if(board[i][0] == 'O')
                dfs(vs, board, i, 0)
            if(board[i][board[0].size-1]=='O')
                dfs(vs, board, i, board[0].size-1)
        }
        for(i in 0 until board[0].size){
            if(board[0][i] == 'O')
                dfs(vs, board, 0, i)
            if(board[board.size-1][i]=='O')
                dfs(vs, board, board.size-1, i)
        }
        for(i in 0 until board.size){
            for(j in 0 until board[0].size){
                if(vs[i][j]){
                    board[i][j] = 'X'
                }
            }
        }
    }
    
    fun dfs(vs: Array<BooleanArray>, board: Array<CharArray>, x: Int, y: Int){
        
        vs[x][y] = false
        var nx = 0
        var ny = 0
        for(i in 0..3){
            nx = x+dx[i]
            ny = y+dy[i]
            if(nx >=0 && ny >= 0 && nx < board.size && ny < board[0].size && board[nx][ny]=='O' && vs[nx][ny])
                dfs(vs, board, nx, ny)
        }
    }
}