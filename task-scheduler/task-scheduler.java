class Solution {
    
    Set<Character> keys = new HashSet<Character>();
    HashMap<Character, Integer> todo = new HashMap<Character, Integer>();
    HashMap<Character, Integer> cooldown = new HashMap<Character, Integer>();
    
    public int leastInterval(char[] tasks, int n) {
        
        int todo_max =0, cool_min = 0, ans = 0, cnt = tasks.length;
        char target = 'a';
        for(char c: tasks){
            keys.add(c);
            todo.putIfAbsent(c, 0);
            todo.compute(c, (k, v)->v+1);
            cooldown.putIfAbsent(c, 0);
        }
        int subtract =0;
        while(cnt-- > 0){
            cool_min = n;
            todo_max = 0;
            for(char c:keys){
                if(todo.get(c) == -1) continue;
                if(cooldown.get(c) == cool_min){
                    if(todo.get(c) > todo_max){
                        target = c;
                        cool_min = cooldown.get(c);
                        todo_max = todo.get(c);
                    }
                }
                else if(cooldown.get(c) < cool_min){
                    target = c;
                    cool_min = cooldown.get(c);
                    todo_max = todo.get(c);
                }
            }
            // System.out.printf("cool_min is %d, job is %s with %d jobs left%n", cool_min, target, todo_max);
            todo.compute(target, (k,v)->v-1);
            subtract = cooldown.get(target)+1;
            ans+=subtract;
            // System.out.printf("target(%s) with sum %d was added to sum(%d)%n", target, cooldown.get(target), ans);
            cooldown.compute(target, (k,v)->n);
            for(char c:keys){
                if(c==target) continue;
                for(int i = 0; i < subtract; i++)
                    if(cooldown.get(c) > 0) cooldown.compute(c, (k,v)-> v-1);
                // System.out.printf("Job %s has %d%n", c, cooldown.get(c));
                if(todo.get(c)==0) todo.compute(c, (k, v)-> -1);
            }
            
        }
        return ans;
    }
}