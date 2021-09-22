import java.lang.Integer;

class Solution {
    public int maxSubArray(int[] nums) {
        
        int ans = -Integer.MAX_VALUE, s;
        for(int i = 0; i < nums.length; i++){
            s =0;
            for(int j = i; j < nums.length; j++){
                s+=nums[j];
                if(s > ans) ans = s;
            }
        }
        return ans;
    }
}