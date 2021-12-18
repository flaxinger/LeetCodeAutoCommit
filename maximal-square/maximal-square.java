class Solution {
    
    int N, M;
    char[][] matrix;
    public int func(int x, int y){
        
        if(Character.compare(matrix[x][y], '0')==0) return 0;
        int d = 1, nx, ny;
              
        while(true){
            nx = x+d;
            ny = y+d;
            if(nx >= N || ny >= M){
                return d;
            }
            for(int i =0; i<=d; i++){
                if(Character.compare(matrix[nx][y+i], '0')== 0){
                    return d;
                }
                if(Character.compare(matrix[x+i][ny], '0')== 0){
                    return d;
                }
            }
            d++;
        }
    }
    
    public int maximalSquare(char[][] matrix) {
        N = matrix.length;
        M = matrix[0].length;
        this.matrix = matrix;
        int max = 0;
        for(int i = 0; i< N; i++){
            for(int j = 0; j < M; j++){
                max = Math.max(max, func(i, j));
            }
        }
        return max*max;
    }
}