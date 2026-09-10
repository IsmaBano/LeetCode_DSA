//
// 
class Solution {
    public long countCommas(long n) {
        long ans=0;
        String s=Long.toString(n);
        int len=s.length();
        long curr=9000;
        for(int i=4;i<len;i++){
            ans+=(curr*((i-1)/3));
            curr=curr*10;
        }
        long start=(long)Math.pow(10,len-1);
        ans+= ((n-start+1)*((len-1)/3));
        return ans;
    }
}