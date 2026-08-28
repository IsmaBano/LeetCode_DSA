class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int hash[]=new int[26];
        for(char ch:s.toCharArray()){
             hash[ch-'a']++;
        }
        int odd=-1;;
        int cntodd=0;
        for(int i=0;i<26;i++){
            if(hash[i]%2==1){
              odd=i;
              hash[i]--;
              cntodd++;
            }
        }
        if(cntodd>1){
            return "";
        }
        String ans="";
        StringBuilder val=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n/2;i++){
          char c=target.charAt(i);
          int idx=-1;
          for(int j=(c-'a')+1;j<26;j++){
             if(hash[j]%2==0 && hash[j]>0){
                idx=j;
                break;
             }
          }
          
          if(idx!=-1){
            hash[idx]-=2;
            StringBuilder curr=new StringBuilder(val);
            curr.append((char)(idx+'a'));
            System.out.println(curr);
            System.out.println(val);
            for(int j=0;j<26;j++){
                char ch=(char)(j+'a');
                int cnt=hash[j];
                while(cnt>1){
                    curr.append(ch);
                    cnt-=2;
                }
            }
           
            if(odd!=-1){
           char o=(char)(odd+'a');
            ans=curr.toString()+""+o+""+curr.reverse().toString();
            }else{
            ans=curr.toString()+""+curr.reverse().toString();
            }
            hash[idx]+=2;
          }
          if(hash[c-'a']==0 ){
            return ans;
          }
          val.append(c);
          hash[c-'a']-=2;
        }
        
            String nans="";
           if(odd!=-1){
           char o=(char)(odd+'a');
            nans=val.toString()+""+o+""+val.reverse().toString();
            }else{
            nans=val.toString()+""+val.reverse().toString();
            }
            if(nans.compareTo(target)>0){
                return nans;
            }
    return ans;
    }
}