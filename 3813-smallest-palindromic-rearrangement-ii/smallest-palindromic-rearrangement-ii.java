class Solution {
     long nCr(int n, int r, int k) {
        //nCr == nC(n-r)
        //5C3 == 5C2
        //5C2 == 5C(5-2) = 5C3
        r = Math.min(r, n - r); //nCr == nC(n-r)

        long result = 1;

        for (int i = 1; i <= r; i++) { //O(log2(k))
            result = result * (n - r + i) / i; //result is becoming twice

            if (result >= k)
                return k;
        }

        return result;
    }

    public String smallestPalindrome(String s, int k) {
        int odd=-1;
        int hash[]=new int[26];
        
        int n=0;
        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
           
        }
       for(int i=0;i<26;i++){
        if(hash[i]%2==1){
            odd=i;
        }
        hash[i]=hash[i]/2;
        n+=hash[i];
       }
       long fact[]=new long[s.length()+1];
        fact[0]=1;
        for(int i=1;i<=s.length();i++){
         fact[i]=fact[i-1]*i;
        }
       StringBuilder ans=new StringBuilder();
       boolean flag=true;
       for(int i=0;i<n;i++){
        boolean found=false;
         for(int j=0;j<26;j++){
            if(hash[j]==0){
                continue;
            }
            hash[j]--;
            int len=n-i-1;
            long f=1;
            for(int t=0;t<26;t++){
                if(hash[t]==0){
                    continue;
                }
                f*=nCr(len,hash[t],k);
                if (f > k) {
    f = k + 1;
    break;
}
                len-=hash[t];
            }
            hash[j]++;
            if(f<k){
                k-=f;
            }else{
                hash[j]--;
                ans.append((char)(j+'a'));
               found=true;
               break;
            }
         }
         if(!found){
            flag=false;
            break;
         }
       }
       if(!flag){
          return "";
       }
       String left=ans.toString();
       if(odd!=-1){
        left+=((char)(odd+'a'));
       }
       return left+ans.reverse().toString();
    }
}