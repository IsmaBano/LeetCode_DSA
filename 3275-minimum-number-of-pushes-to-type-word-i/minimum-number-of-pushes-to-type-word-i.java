class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
         int t=n/8;
         int m=n%8;
         int ans=0;
        while(t>0){
          ans+= 8*t;
          t--;
        }
        t=n/8;
       ans+=m*(t+1);
       return ans;

    }
}