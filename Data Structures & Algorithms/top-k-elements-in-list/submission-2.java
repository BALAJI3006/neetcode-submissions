class Pair{
    int i;
    int f;
    public Pair(int i,int f){
        this.i = i;
        this.f=f;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Pair> res = new ArrayList<>();
        for(int i : map.keySet()){
            res.add(new Pair(i,map.get(i)));  
        }
        Collections.sort(res,new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.f>b.f){
                    return -1;
                }else if(a.f<b.f){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        

        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=res.get(i).i;
        }
        return ans;
    }
}
