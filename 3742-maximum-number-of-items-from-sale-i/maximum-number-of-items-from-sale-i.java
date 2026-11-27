class Solution {
    int pre[];
    int dp[][][];
    public int solve(int i,int k,int cp,int[][] items){
        if(i>=items.length){
            return 0;
        }
        if(k<=0){
            return 0;
        }
        if(dp[i][k][cp]!=-1){
            return dp[i][k][cp];
        }
        //take
        int ans1=0;
        if(items[i][1]<=k){
            ans1=(cp==0?pre[i]:0)+1+solve(i,k-items[i][1],1,items);
        }

        //not take
        int ans2=solve(i+1,k,0,items);
        return dp[i][k][cp]=Math.max(ans1,ans2);
    }
    public int maximumSaleItems(int[][] items, int budget) {
      
        int n=items.length;
        pre=new int[n];
        dp=new int[n][budget+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(items[i][0]%items[j][0]==0){
                        pre[j]++;
                    }
                }
            }
        }
    

       for(int i=0;i<n;i++){
        for(int j=0;j<=budget;j++){
            Arrays.fill(dp[i][j],-1);
        }
       }
        
        return solve(0,budget,0,items);
    }
}