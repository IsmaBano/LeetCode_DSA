class Solution {

    public int minAbsDifference(int[] nums, int goal) {
         int n=nums.length;
         int n1=n/2;
         int n2=n-n1;
         List<Integer> sub1=new ArrayList<>();
         List<Integer> sub2=new ArrayList<>();
         for(int mask=0;mask<(1<<n1);mask++){
            int sum=0;
            for(int j=0;j<n1;j++){
                if((mask&(1<<j))!=0){
                 sum+=nums[j];
                }
            }
            sub1.add(sum);
         }
           for(int mask=0;mask<(1<<n2);mask++){
            int sum=0;
            for(int j=0;j<n2;j++){
                if((mask&(1<<j))!=0){
                 sum+=nums[j+n1];
                }
            }
            sub2.add(sum);
         }
         int ans=Integer.MAX_VALUE;
         Collections.sort(sub2);
         for(int i=0;i<sub1.size();i++){
            int val=goal-sub1.get(i);
            int l=0;
            int r=sub2.size()-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(sub2.get(mid)>=val){
                        ans=Math.min(ans,sub2.get(mid)-val);
                        r=mid-1;
                }else{
                    ans=Math.min(ans,val-sub2.get(mid));
                    l=mid+1;
                }
            }
         }
         return ans;
    }
}