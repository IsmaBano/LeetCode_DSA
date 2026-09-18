class Solution {
    public int check(List<int[]> list,int val){
        int l=0;
        int r=list.size()-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(list.get(mid)[0]<=val){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    public int minSumOfLengths(int[] arr, int target) {
       
       HashMap<Integer,Integer> map=new HashMap<>();
       int n=arr.length;
       map.put(0,-1);
       List<int[]> list=new ArrayList<>();
       int sum=0;
       for(int i=0;i<n;i++){
        sum+=arr[i];
        int left=sum-target;
        if(map.containsKey(left)){
            int len=i-map.get(left);
            list.add(new int[]{i,len});
            System.out.println(i+" "+len);
        }
        map.put(sum,i);
       }
       if(list.size()<=1){
        return -1;
       }
       // 1 11  
     int ans=Integer.MAX_VALUE;
      List<int[]> min=new ArrayList<>();
        min.add(new int[]{list.get(0)[0],list.get(0)[1]});
        for(int i=1;i<list.size();i++){
            int start=list.get(i)[0]-list.get(i)[1]+1;
            int idx =check(min,start-1);
            if(idx!=-1){
            int m=min.get(idx)[1];
            ans=Math.min(ans,m+list.get(i)[1]);
            }
            min.add(new int[]{list.get(i)[0],Math.min(min.get(min.size()-1)[1],list.get(i)[1])});

        }
        if(ans==Integer.MAX_VALUE){
            ans=-1;
        }
        return ans;
    }
}