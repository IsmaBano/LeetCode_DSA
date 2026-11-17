class Solution {
    String s;
    int n;
    int dp1[][];
    int dp2[][];
    public int minval(int start,int end){
        if(dp2[start][end]!=-1){
            return dp2[start][end];
        }
        int mincost=Integer.MAX_VALUE;
        int len=end-start+1;
        for(int d=1;d<len;d++){
            if(len%d!=0){
                continue;
            }
            int cost=0;
            for(int group=0;group<d;group++){
                int l=start+group;
                int r=l+(len/d -1)*d;
                while(l<r){
                   if(s.charAt(l)!=s.charAt(r)){
                    cost++;
                   }
                   l+=d;
                   r-=d;
                }
            }
            mincost=Math.min(cost,mincost);
        }
        return dp2[start][end]=mincost;
    }
    public int solve(int start,int k){
        if(k==0){
            if(start==n){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(start+2*k>n){
            return Integer.MAX_VALUE;
        }
        if(dp1[start][k]!=-1){
            return dp1[start][k];
        }
        int ans=Integer.MAX_VALUE;
        for(int end=start+1;end<n;end++){
            int mincost=solve(end+1,k-1);
            if(mincost==Integer.MAX_VALUE){
                continue;
            }
            int getval=minval(start,end);
            ans=Math.min(ans,mincost+getval);
        }
        return dp1[start][k]= ans;
    }
    public int minimumChanges(String s, int k) {
        n=s.length();
        this.s=s;
        dp1=new int[n][k+1];
        dp2=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp1[i],-1);
             Arrays.fill(dp2[i],-1);
        }
        return solve(0,k);
    }
}