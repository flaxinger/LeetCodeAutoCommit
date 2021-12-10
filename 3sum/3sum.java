class Solution {
    
    List<List<Integer>> ans;
    Map<Integer, Integer> map;
    public List<List<Integer>> threeSum(int[] nums) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        for(int n: nums){
            map.putIfAbsent(n, 0);
            map.compute(n, (k, v)->(v<3)?v+1:v);
        }
        int N = nums.length;
        ArrayList<Integer> tmp;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0;i < N; i++){
            map.compute(nums[i], (k, v) -> v-1);
            for(int j= i+1; j < N; j++){
                if(map.get(nums[j])>0){
                    map.compute(nums[j], (k, v) -> v-1);
                    if(map.getOrDefault(-nums[i]-nums[j], 0) > 0){
                        tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(-nums[j]-nums[i]);
                        Collections.sort(tmp);
                        set.add(tmp);
                    }       
                    map.compute(nums[j], (k, v) -> v+1);
                }
            }
            map.compute(nums[i], (k, v) -> v+1);
        }
        ans = new ArrayList<>(set);
        return ans;
    }
}