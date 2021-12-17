class Solution {
    
    
    int N, left;
    int[] counter;
    int[][] p;
    Map<Integer, ArrayList<Integer>> map;
    
    
    public void func(int num){
        counter[num]=-1;
        left--;
        for(int aa: map.get(num)){
            counter[aa]--;
            if(counter[aa]==0){
                func(aa);
            }
        }
        
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        N = prerequisites.length;
        
        left = numCourses;
        counter = new int[numCourses];
        p = prerequisites;
        map = new HashMap<>();
        
        for(int i =0; i < left; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < N; i++){
            counter[p[i][0]]++;
            map.get(p[i][1]).add(p[i][0]);
        }
        for(int i = 0; i< numCourses; i++){
            if(counter[i] == 0) func(i);
        }

        if(left==0) return true;
        else return false;
    }
}