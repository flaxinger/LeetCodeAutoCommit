class Solution {
    public void rotate(int[] nums, int k) {
        
        int[] cache= new int[k];
        int N = nums.length;
        k = k%N;
        int idx = N-k, i=0;
        
        while(idx<N){
            cache[i] = nums[idx];
            idx++;
            i++;
        }
        
        idx = N-1;
        i = N-k-1;
        while(i>=0){
            nums[idx] = nums[i];
            i--;
            idx--;
        }
        
        idx = 0;
        while(idx < k){
            nums[idx] = cache[idx];
            idx++;
        }
        
    }
}