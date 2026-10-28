class Solution {
    int m, n;
    Integer dp[][][];
   //0-min 1-max
    public Integer[] solve(int i, int j, int[][] grid) {
       Integer ans[]=new Integer[1024];
        if (i == m - 1 && j == n - 1) {
            ans[grid[i][j]]=1;
        }
       if(dp[i][j]!=null){
        return dp[i][j];
       }
        // Right
        if(j+1<n){
        Integer val1[] = solve(i, j + 1, grid);
        for(int k=0;k<1024;k++){
            if(val1[k]!=null && val1[k]==1){
                ans[k^grid[i][j]]=1;
            }
        }
        }
       
        // Down
        if(i+1<m){
        Integer val2[] = solve(i + 1, j, grid);
         for(int k=0;k<1024;k++){
            if(val2[k]!=null &&val2[k]==1){
                ans[k^grid[i][j]]=1;
            }
        }
        }
       return dp[i][j]=ans;
    }

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp=new Integer[m][n][];
       Integer val[]= solve(0, 0, grid);
       for(int i=0;i<1024;i++){
        if(val[i]!=null && val[i]==1){
            return i;
        }
       }
       return 1024;
    }
}