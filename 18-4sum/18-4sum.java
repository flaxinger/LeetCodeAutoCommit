class Solution {
    
    int N, target;
    Integer[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] _nums, int _target) {
        target = _target;
        nums = reduce(_nums).toArray(new Integer[0]);
        N = nums.length-1;
        Arrays.sort(nums);
        traverse(new ArrayList<>(), 0, 0);
        return ans;
    }
    
    private void traverse(List<Integer> list, int sum, int idx){
        
        if(list.size() < 3){
            while(idx < N){
                list.add(nums[idx]);
                traverse(cloneList(list), sum+nums[idx], ++idx);
                list.remove(list.size()-1);
            }
        }
        else{
            idx = isComb(idx, target-sum);
            if(idx > 0){
                list.add(nums[idx]);
                if(!ans.contains(list))
                    ans.add(list);
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
    
    private int isComb(int start, int tar){
        
        if(nums[start] == tar) return start;
        
        int mid = 0;
        int end = N;
        while(start+1 < end){
            mid = (start+end)/2;
            if(nums[mid] < tar)
                start = mid;
            else
                end = mid;
        }
        
        if(nums[end]==tar) return end;
        return -1;
    }
}