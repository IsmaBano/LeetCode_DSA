class Solution {
    int dp[][][]=new int[2][21][21];
    public int solve(int person,int i,int j,int[] nums){
        if(i>j){
            return 0;
        }
        if(i==j){
            if(person==1){
                return nums[i];
            }
            return 0;
        }
        if(dp[person][i][j]!=-1){
            return dp[person][i][j];
        }
        int result;
        if(person==1){
          int c1=nums[i]+solve(0,i+1,j,nums);
          int c2=nums[j]+solve(0,i,j-1,nums);
          result=Math.max(c1,c2);
        } else{
          int c1=solve(1,i+1,j,nums);
          int c2=solve(1,i,j-1,nums);
          result=Math.min(c1,c2);
        }
         return dp[person][i][j]=result;
    }
    public boolean predictTheWinner(int[] nums) {
        for(int i=0;i<2;i++){
            for(int j=0;j<21;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int val=solve(1,0,nums.length-1,nums);
        int s=0;
        for(int n:nums){
            s+=n;
        }
        int nal2=s-val;
        if(val>=nal2){
            return true;
        }
        return false;
    } 
}