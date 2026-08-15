class Solution {
    public int maxProduct(int[] nums) {
        //kadanes algorithm lagate hain
        int n=nums.length;
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
          if(nums[i]<0){
            //exchange kar diya min max
            int temp=max;
            max=min;
            min=temp;
          }
          min=min*nums[i];
          max=max*nums[i];
          min=Math.min(min,nums[i]);
          max=Math.max(max,nums[i]);
          ans=Math.max(ans,max);
        }
        return ans;
    }
}