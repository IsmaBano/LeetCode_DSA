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
       
       for(int i=0;i<n;i++){
        long g=0;
        long l=1;
        for(int j=0;j<n;j++){
            if(i==j){
                continue;
            }
            g=gcd(g,nums[j]);
            l=lcm(l,nums[j]);
        }
         ans=Math.max(ans,l*g);
       }
       long g=0;
        long l=1;
        for(int j=0;j<n;j++){
            g=gcd(g,nums[j]);
            l=lcm(l,nums[j]);
        }
        ans=Math.max(ans,l*g);
       return ans;
    }
}