class Solution {
    public int minimumDeletions(int[] nums) {
        int maxid=0;
        int minid=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[maxid]<nums[i]){
                maxid=i;
            }
            if(nums[minid]>nums[i]){
                minid=i;
            }
        }
        int left=Math.min(maxid,minid);
        int right=Math.max(maxid,minid);

        int val1=left+(n-right)+1;
        int val2=n-left;
        int val3=right+1;
        return Math.min(val1,Math.min(val2,val3));
    }
}