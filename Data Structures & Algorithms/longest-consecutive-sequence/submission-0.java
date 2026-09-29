class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i : nums){
            map.put(i,false);
        }
        int i=0;
        int max=0;
        while(i<nums.length){
            if(map.get(nums[i])){
                i++;
                continue;
            }
            int count=0;
            int curr=nums[i];
            while(map.containsKey(curr)){
                curr--;
            }
            curr++;
            while(map.containsKey(curr)){
                map.put(curr,true);
                count++;
                curr++;
                max=Math.max(count,max);
            }
            i++;
        }
        return max;
    }
}
