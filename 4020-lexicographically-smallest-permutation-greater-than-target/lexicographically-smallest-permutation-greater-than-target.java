class Solution {
    public String lexGreaterPermutation(String s, String target) {
        /*
        bba -  abc
        bca
        */
        int hash[]=new int[26];
        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
        }
        int n=s.length();
       StringBuilder ans=new StringBuilder();
       String res="";
       for(int i=0;i<n;i++){
       char cur=target.charAt(i);
       //just greater val
       int idx=-1;
       for(int j=(cur-'a')+1;j<26;j++){
        if(hash[j]!=0){
          idx=j;
          break;
        }
       }
       if(idx!=-1){
        StringBuilder temp=new StringBuilder();
        temp.append((char)(idx+'a'));
        hash[idx]--;
       for(int j=0;j<26;j++){
         int cnt=hash[j];
         char ch=(char)(j+'a');
         while(cnt>0){
            temp.append(ch);
            cnt--;
         }
       }
       res=ans.toString()+""+temp.toString();
       hash[idx]++;
       }
       if(hash[cur-'a']==0){
         break;
       }
       hash[cur-'a']--;
       ans.append(cur);
       }
       return res;
    }
}