class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        int ans=0;
        for(int i=0;i<piles.length;i++){
            e=Math.max(piles[i],e);
        }
        while(s<=e){
            int mid = s+((e-s)/2);
            boolean isValid = helper(piles,mid,h);
            if(isValid){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean helper(int[] piles,int mid,int h){
        int count=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=mid){
                count++;
            }else{
                count+=(Math.ceil((double)piles[i]/mid));
            }
        }
        if(count>h){
            return false;
        }
        return true;
    }
}
