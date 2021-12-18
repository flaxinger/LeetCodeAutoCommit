class Solution {
    public int[][] merge(int[][] intervals) {
        
        int s, e;
        
        ArrayList<Pair<Integer,Integer>> arr = new ArrayList<>();
        ArrayList<Integer[]> ans = new ArrayList<>();
        for(int[] a:intervals){
            arr.add(new Pair<>(a[0],a[1]));
        }
        
        Collections.sort(arr, (a, b)->(b.getKey()<a.getKey())?1:(b.getKey()==a.getKey())?0:-1);
        s = arr.get(0).getKey();
        e = arr.get(0).getValue();
        
        for(Pair<Integer, Integer> a: arr){
            if(a.getKey() > e){
                ans.add(new Integer[]{s, e});
                s = a.getKey();
                e = a.getValue();
            }
            else e = Math.max(a.getValue(), e);
        }
        ans.add(new Integer[]{s, e});
        
        int[][] result = new int[ans.size()][2];
        
        for(int i = 0;i < ans.size(); i++){
            result[i][0] = ans.get(i)[0];
            result[i][1] = ans.get(i)[1];
        }
        
        return result;
    }
}