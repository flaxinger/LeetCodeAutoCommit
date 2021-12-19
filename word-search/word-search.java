class Solution {
    
    
    int N, M;
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    boolean[][] vs;
    char[][] board;
    
    
    public boolean find(String word, int x, int y){
        
        if(word.length()==0) return true;
        vs[x][y] = true;
        int nx, ny;
        
        for(int i =0;i < 4; i++){
            nx = x+dx[i];
            ny = y+dy[i];
            if(nx >=0 && nx < N && ny >=0 && ny < M && !vs[nx][ny] && board[nx][ny]==word.charAt(0)){
                if(find(word.substring(1), nx, ny)){
                    vs[x][y] = false;
                    return true;
                }
            }
        }
        vs[x][y] = false;
        return false;
        
    }
    
    
    public boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        vs = new boolean[N][M];
        this.board = board;
        for(boolean[] a: vs)
            Arrays.fill(a, false);
        
        for(int i = 0;i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == word.charAt(0)){
                    vs[i][j] = true;
                    if(find(word.substring(1), i, j)){
                        return true;
                    }
                    vs[i][j] = false;
                }
            }
        }
        return false;
    }
}