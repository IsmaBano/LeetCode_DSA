class Solution {
    Integer dp[][];
    // public int solve (int idx,int a[],int ch,int t){
    //     if(idx>=a.length){
    //         if(t==0 && ch==0){
    //             return Integer.MIN_VALUE;
    //         }else if(t==0 && ch==1){
    //             return Integer.MAX_VALUE;
    //         }
    //         return 0;
    //     }
    //     if(dp[idx][ch][t]!=null){
    //         return dp[idx][ch][t];
    //     }
    //     //take
    //    int take=solve(idx+1,a,1-ch,1);
    //    if(ch==0 && take!=Integer.MAX_VALUE){
    //     take=take+a[idx];
    //    }else if(ch==1 && take!=Integer.MIN_VALUE){
    //     take=take-a[idx];
    //    }
    //     //not take
    //     if(idx==a.length-1){
    //         return dp[idx][ch][t]=take;
    //     }
    //     int nt=solve(idx+1,a,ch,t);
    //     if(ch==0){
    //      return dp[idx][ch][t]= Math.max(take,nt);
    //     }else{
    //        return dp[idx][ch][t]=Math.min(take,nt);
    //     }
    // }
     public int solve (int idx,int a[],int ch,int t){
       int n=a.length;
       dp[n-1][0]=a[n-1];
       dp[n-1][1]=-1*a[n-1];
       for(int i=n-2;i>=0;i--){
          //take
           int take=a[i]+dp[i+1][1];
          //nottake
          int nt=dp[i+1][0];
          dp[i][0]=Math.max(take,nt);
          //for bob
           int tak=-a[i]+dp[i+1][0];
          //nottake
          int ntake=dp[i+1][1];
          dp[i][1]=Math.min(tak,ntake);
       }
       return dp[1][0];
    }
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int arr[]=new int[n];
        dp=new Integer[n][2];
        arr[0]=stones[0];
        for(int i=1;i<n;i++){
            arr[i]=stones[i]+arr[i-1];
        }
        int ans=solve(1,arr,0,0);
        return ans;
    }
}