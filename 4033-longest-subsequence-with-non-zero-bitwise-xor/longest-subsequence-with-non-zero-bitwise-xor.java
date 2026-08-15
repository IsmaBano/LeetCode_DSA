class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
          xor=xor^nums[i];
        }
        if(xor!=0){
            return n;
        }
        for(int i=0;i<n;i++){
            if((xor^nums[i])!=0){
                return n-1;
            }
        }
        return 0;
    }
}