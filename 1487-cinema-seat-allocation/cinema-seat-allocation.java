class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans=n*2;
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            int r=reservedSeats[i][0];
            int c=reservedSeats[i][1];
            if(!map.containsKey(r)){
                map.put(r,new int[10]);
            }
            map.get(r)[c-1]=1;
        }
        for(Integer r: map.keySet()){
            int temp[]=map.get(r);
            ans-=2;
            //try taking 1234
             if(temp[1]==0 && temp[2]==0 && temp[3]==0 && temp[4]==0){
                ans++;
                temp[3]=1;
                temp[4]=1;
             }
            //try taking 3456
              if(temp[5]==0 && temp[6]==0 && temp[3]==0 && temp[4]==0){
                ans++;
                temp[5]=1;
                temp[6]=1;
             }
            //try taking 5678
             if(temp[5]==0 && temp[6]==0 && temp[7]==0 && temp[8]==0){
                ans++;
                temp[7]=1;
                temp[8]=1;
             }
        }
        return ans;
    }
}