class Solution {
    public int[] productExceptSelf(int[] nums) {
         int parr[] = new int[nums.length];
         int sarr[] = new int[nums.length];
         parr[0]=1;
         sarr[nums.length-1]=1;
         for(int i=1;i<nums.length;i++){
            parr[i]=parr[i-1]*nums[i-1];
         }
         for(int i=nums.length-2;i>=0;i--){
            sarr[i]=sarr[i+1]*nums[i+1];
         }
         for(int i=0;i<nums.length;i++){
            
                nums[i]=sarr[i]*parr[i];
         }
         return nums;
    }
}  
