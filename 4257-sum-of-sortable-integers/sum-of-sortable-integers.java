import java.util.*;

class Solution {
  //took kmp from old but will rewrite again tomorrow
    public boolean solve(int k, int[] nums, int[] sorted) {
        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int[] lps = new int[k];

            // Build LPS for the sorted block
            int len = 0;
            int i = 1;

            while (i < k) {
                if (sorted[start + i] == sorted[start + len]) {
                    lps[i] = ++len;
                    i++;
                } else if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }

            // Search the sorted block in the circular original block
            int j = 0;
            boolean found = false;

            for (i = 0; i < 2 * k - 1; i++) {
                int value = nums[start + (i % k)];

                while (j > 0 && value != sorted[start + j]) {
                    j = lps[j - 1];
                }

                if (value == sorted[start + j]) {
                    j++;
                }

                if (j == k) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int k1 = i;
                int k2 = n / i;

                if (solve(k1, nums, sorted)) {
                    ans += k1;
                }

                if (k1 != k2 && solve(k2, nums, sorted)) {
                    ans += k2;
                }
            }
        }

        return ans;
    }
}