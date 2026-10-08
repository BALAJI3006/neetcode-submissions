class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            // int count=1;
            while(!s.isEmpty() && temperatures[i]>=temperatures[s.peek()]){
                // count++;
                s.pop();
            }
            if(!s.isEmpty()){
                res[i]=s.peek()-i;
            }else{
                res[i]=0;
            }
            s.push(i);
        }
        return res;
    }
}
