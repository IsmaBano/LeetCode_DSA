class Solution {
    Integer dp[][];
    public int solve(int idx,int ch,int [] s){
        if(idx>=s.length){
            return 0;
        }
        int n=s.length;
        if(dp[idx][ch]!=null){
            return dp[idx][ch];
        }
        int ans;
        if(ch==0){
            //Alice chance
             ans=Integer.MIN_VALUE;
            int sum=0;
              for(int i=idx;i<Math.min(n,idx+3);i++){
                sum+=s[i];
                  int val=solve(i+1,1-ch,s);
                  if(val!=Integer.MIN_VALUE){
                    ans=Math.max(ans,val+sum);
                  }
              }

        }else{
            //Bob Chance
             ans=Integer.MAX_VALUE;
            int sum=0;
              for(int i=idx;i<Math.min(n,idx+3);i++){
                sum+=s[i];
                  int val=solve(i+1,1-ch,s);
                  if(val!=Integer.MAX_VALUE){
                    ans=Math.min(ans,val-sum);
                  }
              }

        }
        return dp[idx][ch]=ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new Integer[n][2];
       
        int ans=solve(0,0,stoneValue);
        if(ans==0){
            return "Tie";
        }else if(ans>0){
            return "Alice";
        }else{
            return "Bob";
        }
    }
}