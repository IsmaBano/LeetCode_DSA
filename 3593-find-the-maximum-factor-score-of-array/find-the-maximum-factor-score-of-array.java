class Solution {
    public long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public long lcm(long a,long b){
        long val=a*b;
        long l=val/gcd(a,b);
        return l;
    }
    public long maxScore(int[] nums) {
        int n=nums.length;
        long ans=0;
        long g=0;
        long l=1;
    
        long posl[]=new long[n];
        long posg[]=new long[n]; 
        for(int i=n-1;i>=0;i--){
          g=gcd(g,nums[i]);
          l=lcm(l,nums[i]);
          posl[i]=l;
          posg[i]=g;
        }
        ans=Math.max(ans,l*g);
        g=0;
        l=1;
       for(int j=0;j<n-1;j++){
          long currg=gcd(g,posg[j+1]);
          long currl=lcm(l,posl[j+1]);
          ans=Math.max(ans,currg*currl);
            g=gcd(g,nums[j]);
            l=lcm(l,nums[j]);
        }
        ans=Math.max(ans,l*g);
       return ans;
    }
}