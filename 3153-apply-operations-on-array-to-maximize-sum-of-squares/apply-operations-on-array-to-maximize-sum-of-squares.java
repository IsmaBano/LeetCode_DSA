class Solution {
    public int maxSum(List<Integer> nums, int k) {
        //1 sort and is always less
        int n=nums.size();
        int cnt[]=new int[32];
        for(int i=0;i<n;i++){
            int v=nums.get(i);
            for(int j=0;j<32;j++){
              int bit=(v>>j)&1;
              if(bit==1){
                cnt[j]++;
              }
            }
        }
        long mod=(long)(1e9)+7;
        long ans=0;
        while(k>0){
            int val=0;
            for(int j=0;j<32;j++){
                if(cnt[j]>0){
                    val=val|(1<<j);
                    cnt[j]--;
                }
            }
            ans=(ans+(val*1L*val*1L)%mod)%mod;
            k--;
        }
        return (int)ans;
    }
}