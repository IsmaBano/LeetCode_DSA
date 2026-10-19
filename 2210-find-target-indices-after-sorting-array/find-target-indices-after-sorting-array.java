class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int cnt=0;
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target){
                cnt++;
            }
            if(nums[i]==target){
                c++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<c;i++){
            ans.add(cnt);
           cnt++;
        }
        return ans;
    }
}