class Solution {
    int max=(int)(1e5) +1;
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
         long dif[]=new long[max];
         for(int i=0;i<n;i++){
            dif[Math.abs(nums1[i]-nums2[i])]++;
        }
        long k=k1+k2;
        for(int i=max-1;i>0;i--){
          if(k<=0){
            break;
          }
          //make i to i-1;
          long cnt=dif[i];
          if(cnt>k){
            dif[i]-=k;
            dif[i-1]+=k;
            k=0;
          }else{
            k-=cnt;
            dif[i]=0;
            dif[i-1]+=cnt;
          }
        }
        long ans=0;
        for(long i=1;i<max;i++){
            long val=i*i;
            ans+= (val*dif[(int)i]);
        }
         return ans;
        
    }
}