class Solution {
    public long gcdd(long a,long b){
        if(b==0){
            return a;
        }
        return gcdd(b,a%b);
    }
    public long count(int coins[],long val){
        //val/num
        int n=coins.length;
        long cnt=0;
        for(int mask=1;mask<(1<<n);mask++){
            int c=0;
            long lcm=1;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    c++;
                   lcm=lcm/gcdd(lcm,coins[i])*coins[i];
                }
                if(lcm>val){
                    break;
                }
            }
            if(lcm>val){
                continue;
            }
                if(c%2==1){
                  cnt+=(val/lcm);
                }
                else{
                    cnt-=(val/lcm);
                }
        }
        return cnt;
    }
    public long findKthSmallest(int[] coins, int k) {
      long result=0;
      int n=coins.length;
      int max=coins[0];
      for(int i=0;i<n;i++){
       max=Math.max(max,coins[i]);
      }
      long l=1;
      long r=max*1L*k;
      while(l<=r){
        long mid=(l+r)/2;
        if(count(coins,mid)>=k){
          result=mid;
          r=mid-1;
        }else{
            l=mid+1;
        }
      }
      return result;
    }
}