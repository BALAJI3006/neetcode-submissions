class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[l]);
                    a.add(nums[r]);
                    res.add(a);
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r]>0){
                    r--;
                }else{
                    l++;
                } 
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> i : res){
            ans.add(i);
        }
        return ans;
    }
}
