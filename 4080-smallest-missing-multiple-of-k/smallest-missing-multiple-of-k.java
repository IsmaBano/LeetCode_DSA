class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int st=k;
        while(st<=200 && set.contains(st)){
            st+=k;
        }
        return st;
    }
}