class Solution {
    public boolean check(int a,int b){
        int  diff=0;
       List<Integer> a1=new ArrayList<>();
       List<Integer> b1=new ArrayList<>();
        while(a>0 || b>0){
            int d1=a%10;
            int d2=b%10;
            a=a/10;
            b=b/10;  
            if(d1!=d2){
                diff++;
                a1.add(d1);
                b1.add(d2);
            }
            if(diff>2){
                return false;
            }
        }
        if(diff==0){
            return true;
        }
        if(diff==1){
            return false;
        }
        if(a1.get(0)==b1.get(1) && a1.get(1)==b1.get(0)){
            return true;
        }
        return false;
    }
    public int countPairs(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(check(nums[i],nums[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}