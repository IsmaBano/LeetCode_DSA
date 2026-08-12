class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int n=nums.length;
       int l=0;
       int r=0;
       int ans=0;
       while(r<n){
        int v=nums[r];
        int val=map.getOrDefault(v,0)+1;
        map.put(v,val);
        while(l<r && map.getOrDefault(v,0)>k){
          int v2=nums[l];
          int val2=map.getOrDefault(v2,0)-1;
          if(val2==0){
            map.remove(v2);
          }else{
            map.put(v2,val2);
          }
          l++;
        }
        ans=Math.max(ans,r-l+1);
        r++;
       }
       return ans;
    }
}