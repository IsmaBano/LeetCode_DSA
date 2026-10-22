class Solution {
    public int minOperations(int[] nums) {
      int n=nums.length;
      int arr[]=new int[2*n];
      for(int i=0;i<n;i++){
        arr[i]=nums[i];
        arr[i+n]=nums[i];
      }
      int asc=-1;
      int lookingfor=0;
      for(int i=0;i<2*n;i++){
        if(arr[i]==lookingfor){
            lookingfor++;
        }else{
            lookingfor=0;
        }
        if(lookingfor==n){
            asc=Math.min(i-n+1,2*n-i+1);
            break;
        }
      }
      System.out.println();
      int desc=-1;
      lookingfor=n-1;
      for(int i=0;i<2*n;i++){
        if(arr[i]==lookingfor){
            lookingfor--;
        }else{
            lookingfor=n-1;
        }
        if(lookingfor==-1){
            desc=Math.min(i-n+1,2*n-i-1);
            break;
        }
      
      }
      if(asc==-1 && desc==-1){
        return -1;
      }
      if(asc==-1){
        return desc+1;
      }
      if(desc==-1){
        return asc;
      }
      return Math.min(asc,desc+1);
    }
}