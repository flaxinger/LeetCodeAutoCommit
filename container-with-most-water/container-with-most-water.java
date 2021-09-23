import java.util.*;
import java.lang.*;

class Solution {
    public int maxArea(int[] height) {
        int max_ = 0, min = 0;
        for(int i =0; i < height.length; i++){
            if(height[i]==0) continue;
            for(int j = max_/height[i]; j < height.length; j++){
                min = Math.min(height[i], height[j]);
                max_ = Math.max(max_, min*(j-i));
            }
            // System.out.printf("at %d max is %d%n", i, max_);
        }
        return max_;
    }
}