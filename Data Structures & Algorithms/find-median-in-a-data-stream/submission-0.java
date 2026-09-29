class MedianFinder {
    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
        // MedianFinder mf = new MedianFinder();

    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek()){
            maxHeap.add((double)num);
        }else{
            minHeap.add((double)num);
        }
        int diff = maxHeap.size()-minHeap.size();
        if(diff==-2){
            maxHeap.add(minHeap.poll());
        }else if(diff==2){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int diff = maxHeap.size()-minHeap.size();
        if(diff==-1){
            return minHeap.peek();
        }else if(diff==0){
            return (minHeap.peek()+maxHeap.peek())/(double)2.0;
        }else if(diff==1){
            return maxHeap.peek();
        }
        return 0;
    }
}
