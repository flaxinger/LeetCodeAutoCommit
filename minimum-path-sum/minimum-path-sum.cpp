#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    
    int vs[201][201];
    vector<vector<int>> board;
    int dx[4] = {1, 0};
    int dy[4] = {0, 1};
    int M, N;
    priority_queue<pair<int, pair<int, int>>> pq;
    
    void trav(int cost, int x, int y){        
        int nx, ny;
        vs[x][y] = 1;
        for(int i =0; i < 2; i++){
            nx = dx[i]+x;
            ny = dy[i]+y;
            if(nx < M && nx >=0 && ny < N && ny >= 0 && !vs[nx][ny]){
                pq.push({cost-board[nx][ny], {nx, ny}});
            }
        }
    }
    
    int minPathSum(vector<vector<int>>& grid) {
        board = grid;
        M = grid.size();
        N = grid[0].size();
        pq.push({-board[0][0],{0,0}});
        int a, b, c;
        while(1){
            a = pq.top().first;
            b = pq.top().second.first;
            c = pq.top().second.second;
            pq.pop();
            if(vs[b][c]) continue;
            if(b == M-1 && c == N-1) return -a;
            trav(a, b, c);   
        }

        return -pq.top().first;
    }
};