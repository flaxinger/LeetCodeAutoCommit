class Solution {
    
    boolean[] check = new boolean[500001];
    public int firstMissingPositive(int[] nums) {
        int max=0, buff;
        Arrays.fill(check, false);
        check[0] = true;
        for(int n:nums){
            if(n>0 && n < 500001){
                check[n] = true;
                if(max==n-1){
                    buff = n;
                    while(buff < 500001 && check[buff]){
                        max = buff;
                        buff++;
                    }
                }
            }
        }
        return max+1;
    }
}