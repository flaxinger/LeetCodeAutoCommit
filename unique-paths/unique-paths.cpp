class Solution {
public:

    int dp[100][100];
    int dx[2] = {1, 0};
    int dy[2] = {0, 1};
    int N, M;
    
    int trav(int x, int y){
        
        if(dp[x][y]) return dp[x][y];
        
        int nx, ny;
        for(int i = 0; i < 2; i++){
            nx = x+dx[i];
            ny = y+dy[i];
            if(nx < M && ny < N){
                dp[x][y] += trav(nx, ny);
                // if(x == 2 && y == 5) cout << dp[x][y];
            }
        }
        
        return dp[x][y];
    }
    
    int uniquePaths(int m, int n) {
        M = m;
        N = n;
        dp[M-1][N-1]=1;
        return trav(0,0);
    }
};