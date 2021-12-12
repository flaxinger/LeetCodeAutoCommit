class Solution {
    
    int x = 0, y = 0, nx, ny, m, n, target;
    int[][] matrix; 
    
    public boolean search(int sx, int sy, boolean isX){

        if(isX){
            while(sx < m){
                if(matrix[sx][sy] == target) return true;
                else if(matrix[sx][sy] > target) break;
                sx++;
            }
        }
        else{
            while(sy < n){
                if(matrix[sx][sy] == target) return true;
                else if(matrix[sx][sy] > target) break;
                sy++;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] ma, int t) {
        matrix = ma;
        target = t;
        m = matrix.length;
        n = matrix[0].length;
        while(x+1 < m && y+1 < n && matrix[x][y] < target ){
            x++;
            y++;
        }
        nx = x;
        ny = y;
    
        while(ny >= 0){
            if(matrix[x][ny] < target){
                if(search(x, ny, true))
                    return true;
            }
            else if(matrix[x][ny] == target) return true;
            ny--;
        }
        while(nx >= 0){
            if(matrix[nx][y] < target){
                if(search(nx, y, false))
                    return true;
            }
            else if(matrix[nx][y] == target) return true;
            nx--;
        }
        
        return false;
    }
}