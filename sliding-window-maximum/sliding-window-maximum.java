class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int N = nums.length, cur;
        int[] arr = new int[N-k+1];
        
        arr[0]=nums[0];
        for(int i = 0; i < k; i++){
            arr[0] = Math.max(arr[0], nums[i]);
        }
        
        
        for(int i = 1; i<= N-k; i++){
            cur = nums[i];
        
            if(arr[i-1] <= nums[i+k-1]){
                cur = nums[i+k-1];
            }
            else if(arr[i-1]!=nums[i-1]){
                cur = Math.max(arr[i-1], nums[i+k-1]);
            }
            else{
                for(int j = i+1; j < i+k; j++){
                    cur = Math.max(cur, nums[j]);
                }
            }
            arr[i]=cur;
        }
        
        return arr;
    }
}