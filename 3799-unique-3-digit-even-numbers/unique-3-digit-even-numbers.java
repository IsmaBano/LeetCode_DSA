class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        HashSet<Integer> set =new HashSet<>();
        for(int i=0;i<n;i++){
            if(digits[i]==0 ) continue;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                for(int k=0;k<n;k++){
                    if(j==k || k==i) continue;
                    if(digits[k]%2==1) continue;
                    int nums=digits[i]*100 +digits[j]*10+digits[k];
                    set.add(nums);
                }
            }
        }
        return set.size();
    }
}