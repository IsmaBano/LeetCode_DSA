class Solution {
    public int minimizeSum(int[] nums) {
        //a b      l     b+l-2*a  make a b to c or a to b  l to l-1   a, b l l-2
        Arrays.sort(nums);
        int n=nums.length;
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        int l2=nums[n-3];
        int l1=nums[n-2];
        int l=nums[n-1];
        //case 1;
        int ans1=l-c;
        int ans2=l1-b;
        int min=b-a;
        int ans3=l2-a;
        return Math.min(ans1,Math.min(ans2,ans3));
       //9 27 33 59 81
    }
}