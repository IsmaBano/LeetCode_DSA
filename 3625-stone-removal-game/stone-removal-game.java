class Solution {
    public boolean canAliceWin(int n) {
        int st=10;
        while(n>0){
          if(n>=st){
             n-=st;
          }else{
            return false;
          }
          st--;
          if(n>=st){
             n-=st;
          }else{
            return true;
          }
          st--;
        }
        return false;
    }
}