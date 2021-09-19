class Solution {
public:
    void rotate(vector<vector<int>>& m) {
        int N = m.size();
        int en = N-1;
        if(N == 1) return;
        
        int half, half2;
        if(N%2){
            half = N/2+1;
            half2 = half -1;
        }
        else{
            half2 = half = N/2;
            
        }
        int tmp = 0, tmpx = 0; 
        int x, y, count;
        for(int i = 0; i< half; i++){
            for(int j = 0; j < half2; j++){
                x = i; y = j;
                tmp = m[i][j];
                count = 4;
                while(count--){
                    // cout << x << ','<< y << endl;
                    if(count == 0){
                        m[x][y] = tmp;   
                    }
                    else{
                        m[x][y] = m[en-y][x];    
                        tmpx = x;
                        x = en - y;
                        y = tmpx;
                    }
                }
                
            }
        }
    }
};