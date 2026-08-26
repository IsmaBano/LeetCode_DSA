class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int len=Integer.MAX_VALUE;
        String ans="";
        int l=0;
        int r=0;
        int cnt=0;
        while(r<n){
            char ch=s.charAt(r);
            if(ch=='1'){
                cnt++;
            }
            while(cnt>k && l<r){
                if(s.charAt(l)=='1'){
                    cnt--;
                }
                l++;
            }
            while(l<r && s.charAt(l)=='0'){
                l++;
            }
            if(cnt==k){
                int v=r-l+1;
                 String curr=s.substring(l,r+1);
                if(len>v){
                    len=v;
                    ans=curr;
                }else if(len==v){
                    if(ans.isEmpty() || ans.compareTo(curr)>0){
                        ans=curr;
                    }
                }
            }
            r++;
        }
        return ans;
    }
}