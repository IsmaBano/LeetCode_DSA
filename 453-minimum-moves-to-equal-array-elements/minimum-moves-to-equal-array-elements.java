class Solution {
    public int minMoves(int[] nums) {
        int count=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
          count+=(nums[i]-nums[0]);
        }
        return count;
    }
}