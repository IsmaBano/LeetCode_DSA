class Solution {
    public long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public long lcm(long a,long b){
        long g=gcd(a,b);
        return (a/g)*b;
    }
    public int maxLength(int[] nums) {
        int n=nums.length;
       
        int ans=0;
        for(int i=0;i<n;i++){
            long g=0;
            long l=1;
            long pr=1;
            for(int j=i;j<n;j++){
              g=gcd(nums[j]*1L,g);
              l=lcm(l,nums[j]*1L);
              pr=pr*nums[j]*1L;
              if(pr==(g*l)){
                ans=Math.max(ans,(j-i+1));
              }
            }
        }
        return ans;
    }
}