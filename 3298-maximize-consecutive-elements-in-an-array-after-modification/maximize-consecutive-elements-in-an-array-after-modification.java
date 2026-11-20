class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
       HashMap<Integer,Integer> dp1=new HashMap<>();//taking as prev
       HashMap<Integer,Integer> dp2=new HashMap<>();
      int pval=-1;
      int cnt=0;
      int maxans=0;
       for(int x:nums){
        if(pval==x){
          cnt++;
          continue;
        }
        
          if(pval!=-1 && pval!=x-1){
            //checkextra for pval+1;
            int v=0;
            if(cnt>1){
                v=1+Math.max(dp1.getOrDefault(pval,0),dp2.getOrDefault(pval,0));
            }else{
                v=1+dp1.getOrDefault(pval,0);
            }
             dp1.put(pval+1,Math.max(dp1.getOrDefault(pval+1,0),v));
             maxans=Math.max(maxans,dp1.get(pval+1));
          }
        //takinf prev
         if(pval==x-1){
            int v=0;
            if(cnt>1){
                v=1+Math.max(dp1.getOrDefault(x-1,0),dp2.getOrDefault(x-1,0));
            }else{
                v=1+dp1.getOrDefault(x-1,0);
            }
            dp1.put(x,Math.max(dp1.getOrDefault(x,0),v));
         }
        //taking or
        int v=1+Math.max(dp1.getOrDefault(x-1,0),dp2.getOrDefault(x-1,0));
        dp2.put(x,Math.max(dp2.getOrDefault(x,0),v));
        pval=x;
        cnt=1;
        maxans=Math.max(maxans,Math.max(dp1.getOrDefault(x,0),dp2.getOrDefault(x,0)));
       }
       int v=0;
       if(cnt>1){
                v=1+Math.max(dp1.getOrDefault(pval,0),dp2.getOrDefault(pval,0));
            }else{
                v=1+dp1.getOrDefault(pval,0);
            }
             dp1.put(pval+1,Math.max(dp1.getOrDefault(pval+1,0),v));
              maxans=Math.max(maxans,dp1.get(pval+1));

      return maxans;
    }
}