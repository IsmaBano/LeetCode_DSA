class Solution {
    public int largestInteger(int[] nums, int k) {
      HashSet<Integer> val[]=new HashSet[51];
      int n=nums.length;
      for(int i=0;i<51;i++){
        val[i]=new HashSet<>();
      }
     for(int i=0;i<=n-k;i++){
        for(int j=i;j<i+k;j++){
           val[nums[j]].add(i);
        }
     }
      for(int i=50;i>=0;i--){
         if(val[i].size()==1){
            return i;
         }
      }
      return -1;
    }
}