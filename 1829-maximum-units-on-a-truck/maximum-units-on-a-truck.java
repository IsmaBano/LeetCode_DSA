class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
       Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
       int ans=0;
       int sz=truckSize;
       for(int i=0;i<boxTypes.length;i++){
           if(sz<=0){
            break;
           }
           if(sz>=boxTypes[i][0]){
            ans+=(boxTypes[i][0]*boxTypes[i][1]);
            sz-=boxTypes[i][0];
           }else{
            ans+=(sz*boxTypes[i][1]);
            sz=0;
           }
           
       }
       return ans;
    }
}