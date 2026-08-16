class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n=stones.length;
        int cnt0=0;
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<n;i++){
           int x=stones[i]%3;
           if(x==0){
            cnt0++;
           }else if(x==1){
            cnt1++;
           }else{
            cnt2++;
           }
        }
        //last part gadbad h
        if(cnt0%2==0){
            return cnt1>=1 && cnt2>=1;
        }
        return cnt1-cnt2>2 || cnt2-cnt1>2;
    }
}