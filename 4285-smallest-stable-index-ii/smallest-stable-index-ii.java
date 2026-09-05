class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int min[]=new int[n];
        min[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
           min[i]=Math.min(min[i+1],nums[i]);
        }
        int max=-1;
        int idx=-1;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if((max-min[i])<=k){
                idx=i;
                System.out.println(max+" "+min[i]+" "+(max-min[i]));
                break;
            }
        }
        return idx;
    }
}