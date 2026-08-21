class Solution {
    public void update(int i,int l,int r,int idx,int seg[]){
        if(l==r){
            seg[i]=seg[i]+1;
            return;
        }
        int mid=(l+r)/2;
        if(idx<=mid){
          update(2*i+1,l,mid,idx,seg);
        }else{
            update(2*i+2,mid+1,r,idx,seg);
        }
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public int find(int i,int l,int r,int ql,int qr,int seg[]){
        if(ql>r || qr<l){
            return 0;
        }
        if(l>=ql && r<=qr){
            return seg[i];
        }
        int mid=(l+r)/2;
        int left=find(2*i+1,l,mid,ql,qr,seg);
        int right=find(2*i+2,mid+1,r,ql,qr,seg);
        return left+right;
    }
    int t;
    public int greaterCount(int seg[],int idx){
    
       int cnt=find(0,0,t-1,idx+1,t-1,seg);
       return cnt;
    }
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=nums[i];
        }
        Arrays.sort(a);
        HashMap<Integer,Integer> map=new HashMap<>();
        int idx=0;
        for(int i=0;i<n;i++){
         if(!map.containsKey(a[i])){
            map.put(a[i],idx);
            idx++;
         }
        }
        int m=4*idx;
        t=idx;
        int seg1[]=new int[m];
        int seg2[]=new int[m];
        List<Integer> arr1=new ArrayList<>();
         List<Integer> arr2=new ArrayList<>();
          update(0,0,idx-1,map.get(nums[0]),seg1);
           update(0,0,idx-1,map.get(nums[1]),seg2);
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2;i<n;i++){
            if(greaterCount(seg1,map.get(nums[i]))>greaterCount(seg2,map.get(nums[i]))){
                update(0,0,idx-1,map.get(nums[i]),seg1);
                arr1.add(nums[i]);
            }else if(greaterCount(seg1,map.get(nums[i]))<greaterCount(seg2,map.get(nums[i]))){
                 update(0,0,idx-1,map.get(nums[i]),seg2);
                arr2.add(nums[i]);
            }else{
                if(arr1.size()>arr2.size()){
                    update(0,0,idx-1,map.get(nums[i]),seg2);
                    arr2.add(nums[i]);
                }else{
                    arr1.add(nums[i]);
                    update(0,0,idx-1,map.get(nums[i]),seg1);
                }
            }
        }
        int ans[]=new int[n];
        for(int i=0;i<arr1.size();i++){
            ans[i]=arr1.get(i);
        }
        for(int i=0;i<arr2.size();i++){
            ans[i+arr1.size()]=arr2.get(i);
        }
        return ans;
    }
}