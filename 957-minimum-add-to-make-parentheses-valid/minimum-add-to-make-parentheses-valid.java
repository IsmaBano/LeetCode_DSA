class Solution {
    public int minAddToMakeValid(String s) {
        int cnt=0;
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0){
             ans+=Math.abs(cnt);
             cnt=0;
            }
        }
        if(cnt>0){
            ans+=cnt;
        }
        return ans;
    }
}