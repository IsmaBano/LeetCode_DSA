class Solution {
    Integer dp[][];
    public int solve(int i,int j,String s,String t){
        if(j>=t.length()){
            return 1;
        }
        if(i>=s.length()){
            return 0;
        }
        if(dp[i][j]!=null){
           return dp[i][j];
        }
        int cnt=0;
        if(s.charAt(i)==t.charAt(j)){
          cnt+= solve(i+1,j+1,s,t);
        }
        cnt+=solve(i+1,j,s,t);
        return dp[i][j]= cnt;
    }
    public int numDistinct(String s, String t) {
        dp=new Integer[s.length()][t.length()];
        return solve(0,0,s,t);
    }
}