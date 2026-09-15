class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            max.add(stones[i]);
        }
        while(!max.isEmpty()&& max.size()>1){
            int x=max.poll();
            int y=max.poll();
            if(x==y){
                continue;
            }else if(x>y){
                max.add(x-y);
            }else{
                max.add(y-x);
            }
        }
        return max.isEmpty()?0:max.poll();
    }
}
