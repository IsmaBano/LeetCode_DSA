class Solution {
    Boolean dp[][];
    List<Integer> list;
    public boolean solve(int n,int c){
       if(n==0){
        if(c==1){
            return true;
        }
        return false;
       }
       if(dp[n][c]!=null){
        return dp[n][c];
       }
       if(c==0){
        boolean flag=false;
       for(int i=0;i<list.size();i++){
        int val=list.get(i);
        if(val>n){
            break;
        }
        boolean ans=solve(n-val,1-c);
        flag=flag|ans;
       }
       return dp[n][c]= flag;
       }else{
        boolean flag=true;
         for(int i=0;i<list.size();i++){
        int val=list.get(i);
        if(val>n){
            break;
        }
        boolean ans=solve(n-val,1-c);
        flag=flag&ans;
       }
       return dp[n][c]= flag;
       }
    }
    public boolean winnerSquareGame(int n) {
        //can i store all squares till n
        //only 316 will be length
       list=new ArrayList<>();
       for(int i=1;i*i<=n;i++){
        list.add(i*i);
       }
       dp=new Boolean[n+1][2];
       return solve(n,0);
    }
}