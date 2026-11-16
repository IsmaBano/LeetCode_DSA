class Solution {
    public StringBuilder solve(StringBuilder temp,int k){
        StringBuilder t=new StringBuilder();
        for(int i=0;i<temp.length();i+=k){
            int sum=0;
            for(int j=i;j<Math.min(i+k,temp.length());j++){
            sum+=(temp.charAt(j)-'0');
            }
            t.append(Integer.toString(sum));
        }
        return t;
    }
    public String digitSum(String s, int k) {
        int n=s.length();
        StringBuilder temp=new StringBuilder(s);
        while(temp.length()>k){
            StringBuilder t=solve(temp,k);
            temp=t;
        }
      return temp.toString();
    }
}