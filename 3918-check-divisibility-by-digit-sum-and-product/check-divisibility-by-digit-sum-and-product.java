class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int temp=n;
        while(temp>0){
            int dig=temp%10;
            sum+=dig;
            prod=prod*dig;
            temp=temp/10;
        }
        int newsum=sum+prod;
        if(n%newsum==0){
            return true;
        }
        return false;
    }
}