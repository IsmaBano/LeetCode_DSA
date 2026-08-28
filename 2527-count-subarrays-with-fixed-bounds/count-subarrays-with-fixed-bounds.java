class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long ans=0;
        int mid=-1;
        int mad=-1;
        int l=0;
        int cid=-1;
        int n=nums.length;
        while(l<n){
             if(nums[l]==minK){
                mid=l;
             }
             if(nums[l]==maxK){
                mad=l;
             }
             if(nums[l]<minK || nums[l]>maxK){
                cid=l;
             }
             if(mid==-1 || mad==-1){
                l++;
                continue;
             }
             int smi=Math.min(mid,mad);
             int v=smi-cid;
             ans+=Math.max(0,v);
             l++;
        }
        return ans;
    }
}