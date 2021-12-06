class Solution {
    
    int[][] vs;
    int[][] grid;
    int target, N, M;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
 
    public int orangesRotting(int[][] grid) {
        int cnt=-1, check=0, nx, ny;
        int max = 0;
        target = 0;
        N = grid.length;
        M = grid[0].length;
        for(int[] a: grid){
            for(int b: a){
                if(b==0) target++;
                if(b==2) check++;
            }
        }
        target = N*M-target;
        
        for(int i = 0;i < N; i++){
            for(int j = 0;j < M; j++){
                switch(grid[i][j]){
                    case(0):
                        grid[i][j] = -2;
                        break;
                    case(1):
                        grid[i][j] = -1;
                        break;
                    case(2):
                        grid[i][j] = 0;
                        break;
                    default:
                        grid[i][j] = -2;
                }
            }
        }
        
        cnt = N*M;
        while(cnt > 0){
            cnt--;
            for(int i = 0; i < N; i++){
                for(int j =0; j< M; j++){
                    if(grid[i][j]>=-1){
                        for(int k = 0; k < 4; k++){
                            nx = i+dx[k];
                            ny = j+dy[k];
                            if(nx >= 0 && nx < N && ny >=0 && ny < M && grid[nx][ny]>-1){
                                if(grid[i][j]==-1) grid[i][j] = Math.min(target, grid[nx][ny]+1);
                                else grid[i][j] = Math.min(grid[i][j], grid[nx][ny]+1);
                            }
                        }   
                    }
                }
            }
        }
        
        check = 0;
        for(int[] a: grid){
            for(int b: a){
                if(b>=0) check++;
                max = Math.max(max, b);
            }
        }
        if(check!=target) return -1;
        return max;
    }
}