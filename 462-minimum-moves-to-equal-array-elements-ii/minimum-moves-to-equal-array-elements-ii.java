class Solution {
    public int minMoves2(int[] nums) {
        //1 2 9 10   
        Arrays.sort(nums);
      int n=nums.length;
       int md=nums[n/2];
       int ans1=0;
        for(int i=0;i<n;i++){
           ans1+=(Math.abs(nums[i]-md));
           
        }
        return ans1;
    }
}