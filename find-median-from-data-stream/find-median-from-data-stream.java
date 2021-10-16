class MedianFinder {
    
    ArrayList<Integer> arr;
    
    public MedianFinder() {
        this.arr = new ArrayList<Integer>();    
    }
    
    public void addNum(int num) {
        
        if(this.arr.size() == 0){
            arr.add(num);
            return;
        }
        
        // if(this.arr.get(0) > num){
        //     this.arr.add(0, num);
        //     return;
        // }
        for(int i = 0 ; i < this.arr.size(); i++){
            if(num <= this.arr.get(i)){
                this.arr.add(i,num);
                return;
            }
        }
        this.arr.add(num);
        return;
    }
    
    public double findMedian() {
        int s = this.arr.size();
        // if(s == 1) return arr.get(0);
        // System.out.printf("cur size = %d\n", s);
        // for(int i = 0 ;i < s; i++) System.out.printf("%d ", this.arr.get(i));
        System.out.println();
        if((s%2) == 0){
            return (this.arr.get(s/2)+this.arr.get(s/2-1))/2.0;
        }
        else return this.arr.get(s/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */