class Solution {
    int pref[];
    int dp[][];
    public int solve(int l,int r,int[]a){
        if(l==r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int tot=pref[r+1]-pref[l];
        int sum=0;
        int ans=0;
        for(int i=l;i<r;i++){
             sum+=a[i];
             int left=sum;
             int right=tot-sum;
             if(right>left){
                int val=left+solve(l,i,a);
                ans=Math.max(ans,val);
             }else if(left>right){
                int val=right+solve(i+1,r,a);
                 ans=Math.max(ans,val);
             }else{
                int val1=left+solve(l,i,a);
                int val2=right+solve(i+1,r,a);
                 ans=Math.max(ans,val1);
                  ans=Math.max(ans,val2);
             }
        }
        return dp[l][r]= ans;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n][n];
        pref=new int[n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
          pref[i+1]=pref[i]+stoneValue[i];
        }
        return solve(0,n-1,stoneValue);
    }
}