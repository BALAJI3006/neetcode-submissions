class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int first[] = new int[nums.length-1];
        int second[] = new int[nums.length-1];
        for(int i=0 ;i<first.length;i++){
            first[i]=nums[i];
            second[i]=nums[i+1];
        }
        int rob=0;
        int notrob=0;
        for(int i=0;i<first.length;i++){
            int temp = notrob;
            notrob=Math.max(rob,notrob);
            rob=Math.max(rob,first[i]+temp);
        }
        int f = Math.max(rob,notrob);
        rob=0;
        notrob=0;
        for(int i=0;i<second.length;i++){
            int temp = notrob;
            notrob=Math.max(rob,notrob);
            rob=Math.max(rob,second[i]+temp);
        }
        int s = Math.max(rob,notrob);
        return Math.max(f,s);
    }
}
