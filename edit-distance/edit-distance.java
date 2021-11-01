import java.io.*;
import java.util.*;
import java.lang.*;
class Solution {
    
    
    String W1, W2;
    int N1, N2;
    int[][] dp;
    int[][] vs;
    public int calc(int idx1, int idx2){
        
        vs[idx1][idx2] = 1;
        if(idx1 == N1){
            return dp[idx1][idx2] = N2 - idx2;
        }
        if(idx2 == N2){
            return dp[idx1][idx2] = N1 - idx1;
        }
        int ins, del, rep;
        
        if(vs[idx1+1][idx2] == 0)
            ins = calc(idx1+1, idx2) + 1;
        else
            ins = dp[idx1+1][idx2]+1;
        
        if(vs[idx1][idx2+1] == 0)
            del = calc(idx1, idx2+1) + 1;
        else
            del = dp[idx1][idx2 +1]+1;
        
        if(vs[idx1+1][idx2+1] == 0)
            rep = calc(idx1+1, idx2+1);
        else
            rep = dp[idx1+1][idx2+1];
        
        if(W1.charAt(idx1) != W2.charAt(idx2)){
            rep++;
        }
        
        return dp[idx1][idx2] = Math.min(ins, Math.min(del, rep));
    }
    
    
    
    public int minDistance(String word1, String word2) {
        W1 = word1;
        W2 = word2;
        N1 = W1.length();
        N2 = W2.length();
        dp = new int[N1+1][N2+1];
        vs = new int[N1+1][N2+1];
        
        for(int[] row: vs)
            Arrays.fill(row, 0);
        for(int[] row: dp)
            Arrays.fill(row, 0);
        return calc(0, 0);
    }
}