class Solution {
    int dp[][][];
    public int solve(int i,int c,int m,int [] p){
        if(i>=p.length){
            return 0;
        }
        if(dp[i][c][m]!=-1){
            return dp[i][c][m];
        }
        if(c==0){
            int sum=0;
            int max=0;
        for(int j=i;j<=Math.min(p.length-1,i+2*m-1);j++){
          sum+=p[j];
          int val=solve(j+1,1-c,Math.max(j-i+1,m),p);
          max=Math.max(max,sum+val);
        }
        return dp[i][c][m]=max;
        }else{
          int min=Integer.MAX_VALUE;
          for(int j=i;j<=Math.min(p.length-1,i+2*m-1);j++){
          int val=solve(j+1,1-c,Math.max(j-i+1,m),p);
          min=Math.min(min,val);
        }
        return dp[i][c][m]=min;
        }
    }
    public int stoneGameII(int[] piles) {
        dp=new int[piles.length][2][101];
        for(int i=0;i<piles.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,1,piles);
    }
}