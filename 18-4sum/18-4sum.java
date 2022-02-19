class Solution {
    
    int N, target;
    Integer[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] _nums, int _target) {
        
        target = _target;
        List<Integer> tmp = reduce(_nums);
        nums = tmp.toArray(new Integer[0]);
        N = nums.length;
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
            List<Integer> newList = cloneList(list);
            List<Integer> addList;
            while(idx < N){
                if(sum+nums[idx]==target){
                    newList.add(nums[idx]);
                    addList = cloneList(newList);
                    Collections.sort(addList);
                    if(!ans.contains(addList))
                        ans.add(addList);
                    newList.remove(3);
                }
                idx++;
            }
            return;
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