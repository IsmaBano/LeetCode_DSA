class Solution {
    int n;
    int m;
    int mod=(int)(1e9)+7;
    //1 right 0 down 
    int dp[][][];
    public int solve(int i,int j,int prev,int [][] grid){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>=n || j>=m ){
            return 0;
        }
        if(dp[i][j][prev]!=-1){
            return dp[i][j][prev];
        }
        if(grid[i][j]==1){
            if(prev==0){
               return solve(i,j+1,1,grid);
            }else{
                return solve(i+1,j,0,grid);
            }
        }
        //right
         int cnt1=solve(i,j+1,1,grid);

        //down
        int cnt2=solve(i+1,j,0,grid);
        return dp[i][j][prev]=(cnt1+cnt2)%mod;
    }
    public int uniquePaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new int[n][m][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans=solve(0,0,0,grid);
        return ans;
    }
}