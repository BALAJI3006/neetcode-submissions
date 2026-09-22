class Solution {
    public int rob(int[] nums) {
        int rob=0;
        int notrob=0;
        for(int i=0;i<nums.length;i++){
            int temp = notrob;
            notrob=Math.max(rob,notrob);
            rob=Math.max(rob,nums[i]+temp);
        }
        return Math.max(rob,notrob);
    }
}
