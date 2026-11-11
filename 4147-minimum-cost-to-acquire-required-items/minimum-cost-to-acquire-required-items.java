class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans=0;
        if((cost1+cost2)>costBoth){
           ans+=(costBoth*1L*Math.min(need1,need2));
           int min=Math.min(need1,need2);
           need1-=min;
           need2-=min;
        }
            ans+=Math.min(costBoth,cost1)*1L*need1;
           
            ans+=Math.min(costBoth,cost2)*1L*need2;
        return ans;
    }
}