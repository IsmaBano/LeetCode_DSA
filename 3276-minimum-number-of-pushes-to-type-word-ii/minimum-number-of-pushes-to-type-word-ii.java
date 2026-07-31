class Solution {
    public int minimumPushes(String word) {
        int hash[]=new int[26];
        for(char ch:word.toCharArray()){
            hash[ch-'a']++;
        }
        Arrays.sort(hash);
        int ans=0;
        for(int i=25;i>=0;i--){
            if(i>=18){
              ans+=hash[i];
            }else if(i>=10){
                ans+=(hash[i]*2);
            }else if(i>=2){
                ans+=(hash[i]*3);
            }else{
                ans+=(hash[i]*4);
            }
        }
        return ans;
    }
}