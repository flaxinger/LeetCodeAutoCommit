class Solution {
    
    int N, target;
    Integer[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] _nums, int _target) {
        target = _target;
        nums = reduce(_nums).toArray(new Integer[0]);
        N = nums.length;
        Arrays.sort(nums);
        traverse(new ArrayList<>(), 0, 0);
        return ans;
    }
    
    private void traverse(List<Integer> list, int sum, int idx){
        
        if(list.size() < 3){
            while(idx < N){
                list.add(nums[idx]);
                traverse(list, sum+nums[idx], ++idx);
                list.remove(list.size()-1);
            }
        }
        else{
            int lookingFor = target-sum;
            int cur = Integer.MIN_VALUE;
            while(idx < N && nums[idx] > cur){
                if(nums[idx]==lookingFor){
                    list.add(nums[idx]);
                    if(!ans.contains(list))
                        ans.add(cloneList(list));
                    list.remove(3);
                    cur = nums[idx];
                }
                idx++;
            }
        }
    }
       
    private List<Integer> cloneList(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(Integer i: list){
            result.add(i);
        }
        return result;
    }
    
    private List<Integer> reduce(int[] list){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<>();
        for(Integer i: list){
            map.putIfAbsent(i, 0);
            if(map.get(i) < 4){
                result.add(i);
                map.put(i, map.get(i)+1);
            }
        }
        return result;
    }
}