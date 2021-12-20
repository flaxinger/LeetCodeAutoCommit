class Solution {
    public int maximalRectangle(char[][] m) {
        
        int N = m.length, M = m[0].length, x, y, best = 0, ii;
        int[][] rightdp = new int[N][M];
        int[][] downdp = new int[N][M];
        
        
        for(int i = 0; i < M; i++){
            downdp[N-1][i] = (m[N-1][i]=='1')?1:0;
            for(int j = N-2; j >= 0; j--){
                downdp[j][i] = (m[j][i]=='1')?downdp[j+1][i]+1:0;
            }
        }
        
        for(int i = 0; i < N; i++){
            rightdp[i][M-1] = (m[i][M-1]=='1')?1:0;
            for(int j = M-2; j >= 0; j--){
                rightdp[i][j] = (m[i][j]=='1')?rightdp[i][j+1]+1:0;
            }
        }
        
        for(int i =0; i < N; i++){
            for(int j = 0; j < M; j++){
                x = rightdp[i][j];
                y = downdp[i][j];
                ii = 0; 
                
                while(x*y > best && ii < y){
                    x = Math.min(x, rightdp[ii+i][j]);
                    best = Math.max(best, x*(ii+1));
                    ii++;
                }
            }
        }
        return best;

    }
}