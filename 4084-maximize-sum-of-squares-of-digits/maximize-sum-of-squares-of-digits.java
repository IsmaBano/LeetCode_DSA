class Solution {
    public String maxSumOfSquares(int n, int sum) {
        StringBuilder ans=new StringBuilder();
        while(n>0){
            if(sum>9){
                ans.append("9");
                sum-=9;
            }else{
                ans.append(sum+"");
                sum=0;
            }
            n--;
        }
        if(sum>0){
            return "";
        }
        return ans.toString();
    }
}