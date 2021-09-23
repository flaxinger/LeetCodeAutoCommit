class Solution {
    
    
    
    public int trap(int[] h) {
        
           
        int lHigh = h[0], rHigh = h[0], rLow = h[0];
        int lHighIdx = 1, rHighIdx = 1, rLowIdx = 1;
        int ans=0;
        
        for(int i = 0; i < h.length; i++){
            
            // case 1: you find a taller or equal wall
            //   - fill everything before to lHigh
            //   - replace lHigh;
            // case 2: you dont find a taller wall
            //   case 2.1: wall is shorter than rLow
            //     - update right low
            //   case 2.2: wall is taller than right low
            //     - fill everything before
            if(h[i] >= lHigh){
                for(int j = lHighIdx; j < i; j++){
                    ans += lHigh - h[j];
                    h[j] = lHigh;
                }
                lHighIdx = i;
                lHigh = h[i];
            }
            else{
                if(h[i] <= rLow){
                    rLow = h[i];
                }
                else{
                    for(int j = lHighIdx+1; j < i; j++){
                        if(h[i]>h[j]){
                            ans += h[i] - h[j];
                            h[j] = h[i];
                        }
                    } 
                }
            }
            
        }
        return ans;
    }
}