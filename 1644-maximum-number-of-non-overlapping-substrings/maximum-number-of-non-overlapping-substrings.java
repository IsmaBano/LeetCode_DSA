class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans=new ArrayList<>();
        int n=s.length();
        int start[]=new int[26];
        int end[]=new int[26];
        boolean isvalid[]=new boolean[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);
        Arrays.fill(isvalid,true);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
         if(start[ch-'a']==-1){
            start[ch-'a']=i;
         }
         end[ch-'a']=i;
        }
        for(int c=0;c<26;c++){
            if(start[c]==-1){
                continue;
            }
            for(int i=start[c];i<=end[c];i++){
                int ch=s.charAt(i)-'a';
                if(start[ch]<start[c]){
                    isvalid[c]=false;
                    break;
                }
                end[c]=Math.max(end[c],end[ch]);
            }
        }
        int laststart=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int c=s.charAt(i)-'a';
            if(!isvalid[c]){
                continue;
            }
            if(i==start[c] && end[c]<laststart){
                ans.add(s.substring(i,end[c]+1));
                laststart=i;
            }
        }
        return ans;
    }
}