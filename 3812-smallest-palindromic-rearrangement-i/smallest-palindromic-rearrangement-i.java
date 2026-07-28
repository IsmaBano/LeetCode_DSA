class Solution {
    public String smallestPalindrome(String s) {
        int cnt[]=new int[26];
        for(char ch:s.toCharArray()){
            cnt[ch-'a']++;
        }
        int odd=-1;
         StringBuilder ans=new StringBuilder();
         StringBuilder rev=new StringBuilder();
        for(int i=0;i<26;i++){
           if(cnt[i]==0){
            continue;
           }
           if(cnt[i]%2==1){
            odd=i;
           }
           int val=cnt[i]/2;
           for(int j=0;j<val;j++){
            ans.append((char)(i+'a'));
            rev.append((char)(i+'a'));
           }
        }
          rev.reverse();
          if(odd!=-1){
        ans.append((char)(odd+'a'));
          }
        ans.append(rev);

        return ans.toString();
    }
}