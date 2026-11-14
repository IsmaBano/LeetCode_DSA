class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sm=0;
            for(int j=i;j<n;j++){
                sm+=nums.get(j);
                int len=j-i+1;
                if(len>=l && len<=r && sm>0){
                  ans=Math.min(ans,sm);
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}