class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap= new PriorityQueue<>();
        for(int i:nums){
            add(i);
        }
    }
     
    public int add(int val) {
        
        if(minHeap.size()>=k){
            if(minHeap.peek()<val){
                minHeap.poll();
                minHeap.offer(val);
            }
        }else{
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}