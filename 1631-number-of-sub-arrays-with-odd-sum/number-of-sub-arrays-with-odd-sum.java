class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int a[]=new int[n];
        for(int i=0;i<arr.length;i++){
            a[i]=i==0?0:a[i-1];
            if(arr[i]%2==1){
            a[i]++;
            }
        }
        int odd=0;
        int even=1;
        int cnt=0;
        for(int i=0;i<a.length;i++){
            if(a[i]%2==1){
             cnt=(cnt+even)%mod;
             odd++;
            }else{
                cnt=(cnt+odd)%mod;
                even++;
            }
        }
        return cnt;
    }
}