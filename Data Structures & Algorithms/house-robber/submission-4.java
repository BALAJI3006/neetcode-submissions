class Solution {
    public int rob(int[] cost) {
        int rob=0;
        int notrob=0;
        for(int i=0;i<cost.length;i++){
            int temp=Math.max(rob,notrob);
            rob=cost[i]+notrob;
            notrob=temp;
        }
        return Math.max(rob,notrob);
    }
}
