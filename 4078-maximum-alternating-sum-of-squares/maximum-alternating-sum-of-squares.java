class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans=0;
        List<Long> val=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            long va=nums[i]*1L*nums[i];
            val.add(va);
        }
        Collections.sort(val);
        int v=n/2;
        for(int i=0;i<v;i++){
            ans-=val.get(i);
        }
        for(int i=v;i<n;i++){
            ans+=val.get(i);
        }
        return ans;
    }
}