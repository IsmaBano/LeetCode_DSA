class Solution {
    public boolean check(int n,int t){
        int prod=1;
        while(n>0){
            int d=n%10;
            n=n/10;
            prod=prod*d;
        }
        if(prod%t==0){
            return true;
        }
        return false;
    }
    public int smallestNumber(int n, int t) {
       
      while(true){
        if(check(n,t)){
            break;
        }
        n++;
      }
  return n;
    }
}