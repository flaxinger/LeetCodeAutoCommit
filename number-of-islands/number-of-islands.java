class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] vs = new boolean[300][300];
    char[][] g;
    int ans, M, N; 
    private void dfs(int x, int y){
        
        vs[x][y] = true;
        
        int ny =0, nx = 0;
        for(int i = 0; i < 4; i++){
            nx = x+dx[i];
            ny = y+dy[i];
            if(ny >= 0 && ny < N && nx >= 0 && nx < M && !vs[nx][ny] && g[nx][ny]=='1'){
                dfs(nx, ny);
            }
        }
        
    }
    public int numIslands(char[][] grid) {
        g = grid;
        M = grid.length;
        N = grid[0].length;
        for(int i = 0 ; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!vs[i][j] && g[i][j] == '1'){
                    ans++;
                    dfs(i, j);
                }
            }
        }
        return ans;
    }
}