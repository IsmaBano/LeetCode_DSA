class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n=s.length();
       int ans[]=new int[n];
       int cnt1=0;
       int cnt2=0; 
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(cnt1<cnt2){
                    cnt1++;
                    ans[i]=1;
                }else{
                 cnt2++;
                }
            }else{
               if(cnt1>0){
                ans[i]=1;
                cnt1--;
               }else{
                cnt2--;
               }
            }
        }
        return ans;
    }
}