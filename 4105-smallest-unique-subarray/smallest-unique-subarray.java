
class Solution {
    long mod = 1000000007L;
    long inv2 = 500000004L;
  public long exp(long a,long b){
    if(b==0){
        return 1;
    }
    if(b==1){
        return a;
    }
    long half=exp(a,b/2);
    long ans=(half*half)%mod;
    if(b%2==1){
      ans=(ans*a)%mod;
    }
    return ans;
  }
    public boolean find(int[] nums, int k) {
        int n = nums.length;
        long p = 1;
        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum = (sum + nums[i] * p % mod) % mod;
            p = (p * 2) % mod;
        }
        HashMap<Long, Integer> set = new HashMap<>();
        set.put(sum, 1);

        for (int i = k; i < n; i++) {
            sum = (sum + p * nums[i] % mod) % mod;
            sum = (sum - nums[i-k] + mod) % mod;
            sum = (sum * exp(2,mod-2)) % mod;

            set.put(sum, set.getOrDefault(sum, 0) + 1);
        }

        for (int count : set.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int l = 1, r = n;
        int ans = n;

        while (l <= r) {
            int mid = l + (r-l)/2;

            if (find(nums, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
