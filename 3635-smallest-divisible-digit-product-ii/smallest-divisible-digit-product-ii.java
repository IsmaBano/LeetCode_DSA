class Solution {
    public String left(long req,int len){
        StringBuilder ans=new StringBuilder();
        for(int dig=9;dig>=2;dig--){
            while(req%dig==0){
                ans.append((char)(dig+'0'));
                req=req/dig;
            }
        }
        while(ans.length()<len){
            ans.append('1');
        }
        return ans.reverse().toString();
    }
    public String smallestNumber(String num, long t) {
        /*
        mod <=t 

        i,lim, mod
        */
        int n=num.length();
        int cnt2=0;
        int cnt3=0;
        int cnt5=0;
        int cnt7=0;
        long temp=t;
        while(temp%2==0){cnt2++;temp/=2;}
        while(temp%3==0){cnt3++;temp/=3;}
        while(temp%5==0){cnt2++;temp/=5;}
        while(temp%7==0){cnt2++;temp/=7;}
        if(temp!=1){
          return "-1";
        }
        long[] remainingFactor = new long[n + 1];
        remainingFactor[0] = t;
        // "123045"
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';

            if (digit == 0) {
                break;
            }

            remainingFactor[i + 1] = remainingFactor[i] / gcd(remainingFactor[i], digit);
        }

        if (remainingFactor[n] == 1) {   
            return num;
        }
        int zeroPos = num.indexOf('0');
        int zeroIdx = n - 1;
        if (zeroPos != -1) {
            zeroIdx = zeroPos;
        }
         for (int i = zeroIdx; i >= 0; i--) {
            long required = remainingFactor[i];
            int freeSlots = n - 1 - i;   // free slots to the right of i

            for (int digit = (num.charAt(i) - '0') + 1; digit <= 9; digit++) {
                long furtherRequired = required / gcd(required, digit);
                String requiredNumber = left(furtherRequired, freeSlots);

                if (requiredNumber.length() == freeSlots) {
                    return num.substring(0, i) + (char) (digit + '0') + requiredNumber;
                }
            }
        }

      return left(t,n+1);
    }
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}