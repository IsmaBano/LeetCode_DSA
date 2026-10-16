class Solution {
    long mod=(long)(1e9)+7;
    long seg1[];
    long seg2[];
    long lazy[];
    public void lazyadd(int i,int l,int r,long val){
        if(val==0){
            return;
        }
        long len=(r-l+1);
        
        seg2[i]=(seg2[i]+(len*val*val%mod+2*seg1[i]*val%mod)%mod)%mod;
        seg1[i]=(seg1[i]+len*val)%mod;
    }
    public void add(int i,int l,int r,int ql,int qr){
         if(lazy[i]>0){
        lazyadd(i,l,r,lazy[i]);
       if(l!=r){
        lazy[2*i+1]+=lazy[i];
        lazy[2*i+2]+=lazy[i];
       }
        lazy[i]=0;
       }


       if(l>qr ||r<ql){
        return;
       }
       if(l>=ql && r<=qr){
        lazyadd(i,l,r,1);
        if(l!=r){
        lazy[2*i+1]+=1;
        lazy[2*i+2]+=1;
       }
        return;
       }
        int mid=(l+r)/2;
        add(2*i+1,l,mid,ql,qr);
        add(2*i+2,mid+1,r,ql,qr);
        seg1[i]=(seg1[2*i+1]+seg1[2*i+2])%mod;
        seg2[i]=(seg2[2*i+1]+seg2[2*i+2])%mod;
    }
    public int sumCounts(int[] nums) {
        //ending at i
        int n=nums.length;
        seg1=new long[4*n];
        seg2=new long[4*n]; 
        lazy=new long[4*n];
        long ans=0;
        HashMap<Integer,Integer> map=new HashMap<>(); 
        for(int i=0;i<n;i++){
           int t=map.getOrDefault(nums[i],-1);
           add(0,0,n-1,t+1,i);
           ans=(ans+seg2[0])%mod;
           System.out.println(seg2[0]);
          map.put(nums[i],i);
        }
        return (int)ans;
    }
}
