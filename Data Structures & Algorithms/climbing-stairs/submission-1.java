class Solution {
    public int climbStairs(int n) {
        int one = 1;
        int two = 2;
        if(n==1){
            return 1;
        }
        for(int i=0;i<n-2;i++){
            int temp = one + two;
            one =two;
            two=temp;
        }
        return two;
    }
}
