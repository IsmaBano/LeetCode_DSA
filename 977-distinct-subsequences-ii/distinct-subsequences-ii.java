// log n remove karna padega
class Solution {
    int comp[][];
    int mod=(int)(1e9)+7;
    int dp[][];
    int idx=0;
    // public int find(List<Integer> v,int id){
    //     if(v.size()==0){
    //         return -1;
    //     }
        
    //     int ans=-1;
    //     int l=0;
    //     int r=v.size()-1;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         if(v.get(mid)>id){
    //             r=mid-1;
    //             ans=v.get(mid);
    //         }else{
    //             l=mid+1;
    //         }
    //     }
    //     return ans;
    // }
    public int solve(int prev,int n){
        if(idx>=n){
            return 1;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
       int cnt=1;
       // taking cnt as 1 for idx-1 position
       if(prev==-1){
        cnt=0;
       }
       //taking values for idx position now
        for(int j=0;j<26;j++){
          int nidx=comp[j][prev+1];
          if(nidx!=-1){
            //  System.out.println(idx+" pe "+nidx+" ye"+(char)(j+'a'));
            cnt=(cnt+solve(nidx,n))%mod;
          }
        }
        return dp[idx][prev+1]=cnt;
    }
    public int distinctSubseqII(String s) {
        int n=s.length();
     comp=new int[26][n+1];
     for(int i=0;i<26;i++){
    Arrays.fill(comp[i],-1);
     }
      for(int i=0;i<n;i++){
        comp[s.charAt(i)-'a'][i]=i;
      }
      for(int i=0;i<26;i++){
        for(int j=n-1;j>=0;j--){
            if(comp[i][j]==-1){
                comp[i][j]=comp[i][j+1];
            }
        }
      }
      dp=new int [1][n+1];
      for(int i=0;i<1;i++){
        Arrays.fill(dp[i],-1);
      }
     int cnt=solve(-1,n);
     return cnt;
    }
}
