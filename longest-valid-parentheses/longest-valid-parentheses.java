class Solution {
    
    int[] dp;
    public int longestValidParentheses(String s) {
        
        
        int best = 0, idx, N = s.length();
        dp = new int[N+1];
        char c;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0;i < N; i++){
            c = s.charAt(i);
            if(c==')'){
                if(!stack.empty()){
                    if(s.charAt(i-1)=='(')
                        dp[i] = dp[Math.max(0,i-2)]+2;
                    else{
                        idx = i-dp[i-1]-2;
                        dp[i] = dp[i-1]+dp[idx<0?N:idx]+2;
                    }
                    stack.pop();
                    best = Math.max(dp[i], best);   
                }
            }   
            else stack.push(c);
        }
        return best;
    }
}