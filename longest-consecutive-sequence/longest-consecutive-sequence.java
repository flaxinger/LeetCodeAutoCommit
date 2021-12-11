class Solution {
    
    
    public int recursion(int k, boolean start){
        
        if(map.containsKey(k-1)){
            if(map.get(k-1)>1) return map.get(k-1)+1;
            return recursion(k-1, false)+1;
        }
        return 1;
    }
    
    Map<Integer, Integer> map;
    public int longestConsecutive(int[] nums) {
        map =  new HashMap<>();
        
        for(int n: nums)
            map.put(n, 1);
        int max = 0;
        // System.out.println(map);
        for(int ks: map.keySet()){
            map.compute(ks, (j, s)->recursion(j, true));
            max = Math.max(max, map.getOrDefault(ks, 0));
        }
        // System.out.println(map);
        return max;
    }
}