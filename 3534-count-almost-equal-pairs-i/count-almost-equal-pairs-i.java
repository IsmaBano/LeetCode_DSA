class Solution {
     public boolean check(int a, int b) {

        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);

        int len = Math.max(s1.length(), s2.length());

        // Add leading zeros
        while (s1.length() < len) {
            s1 = "0" + s1;
        }

        while (s2.length() < len) {
            s2 = "0" + s2;
        }

        int diff = 0;
        int first1 = -1, first2 = -1;
        int second1 = -1, second2 = -1;

        for (int i = 0; i < len; i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                diff++;

                if (diff == 1) {
                    first1 = s1.charAt(i);
                    first2 = s2.charAt(i);
                } 
                else if (diff == 2) {
                    second1 = s1.charAt(i);
                    second2 = s2.charAt(i);
                } 
                else {
                    return false;
                }
            }
        }

        // Already equal
        if (diff == 0) {
            return true;
        }

        return first1 == second2 && first2 == second1;
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