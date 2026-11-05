// class Solution {
//     Long dp[][];
//     public long solve(int i,int c,long[] arr,int k,int x){
//         if(c>=k){
//             return 0;
//         }
//         if(i>=arr.length){
//             return Long.MAX_VALUE;
//         }
//         if(dp[i][c]!=null){
//             return dp[i][c];
//         }
//         long val1=arr[i]+solve(i+x,c+1,arr,k,x);
//         long val2=solve(i+1,c,arr,k,x);
//         return dp[i][c]=Math.min(val1,val2);
//     }
//     public long minOperations(int[] nums, int x, int k) {
       
//         int n=nums.length;

//         dp=new Long[n][k+1];
//         long mincost[]=new long[n-x+1];
//         x=x-1;
//         TreeMap<Integer,Integer> left=new TreeMap<>();
//         TreeMap<Integer,Integer> right=new TreeMap<>();
//          int ls=0;
//          int rs=0;
//          long leftsum=0;
//          long rightsum=0;
//         for(int i=0;i<x;i++){
//             left.put(nums[i],left.getOrDefault(nums[i],0)+1);
//             ls++;
//             leftsum+=nums[i];
//             if(ls-rs>=2){
//               int val=left.lastKey();
//               int p=left.get(val);
//               if(p>1){
//                 left.put(val,p-1);
//               }else{
//                 left.remove(val);
//               }
//               leftsum-=val;
//               ls--;
//               right.put(val,right.getOrDefault(val,0)+1);
//               rightsum+=val;
//               rs++;
//             }
//         }
//         for(int i=x;i<n;i++){
//             left.put(nums[i],left.getOrDefault(nums[i],0)+1);
//             ls++;
//             leftsum+=nums[i];
//             if(ls>=2){
//               int val=left.lastKey();
//               int p=left.get(val);
//               if(p>1){
//                 left.put(val,p-1);
//               }else{
//                 left.remove(val);
//               }
//               leftsum-=val;
//               ls--;
//               right.put(val,right.getOrDefault(val,0)+1);
//               rightsum+=val;
//               rs++;
//             }
//          int maxleft=left.lastKey();
//          int minright=right.firstKey();
//          int median=maxleft;
//          mincost[i-x]=median*ls-leftsum+rightsum-median*rs;

//          //remove i-x
//          int v=nums[i-x];
//         if(v<=maxleft){
//           ls--;
//           leftsum-=v;
//           if(left.get(v)>1){
//             left.put(v,left.get(v)-1);
//           }else{
//             left.remove(v);
//           }
//           if(ls<rs){
//            ls++;
//            rs--;
//            leftsum += minright;
//            rightsum -= minright;
//            left.put(minright,left.getOrDefault(minright,0)+1);
//            if(right.get(minright)>1){
//             right.put(minright,right.get(minright)-1);
//            }else{
//             right.remove(minright);
//            }
//           }
//         }else{
//             rs--;
//             rightsum-=v;
//           if(right.get(v)>1){
//             right.put(v,right.get(v)-1);
//            }else{
//             right.remove(v);
//            }
//           if(ls-rs>=2){
//               int val=left.lastKey();
//               int p=left.get(val);
//               if(p>1){
//                 left.put(val,p-1);
//               }else{
//                 left.remove(val);
//               }
//               leftsum-=val;
//               ls--;
//               right.put(val,right.getOrDefault(val,0)+1);
//               rightsum+=val;
//               rs++;
//             }
//         }
//         }
//         return solve(0,0,mincost,k,x+1);
//     }
// }


class Solution {
    Long[][] dp;

    public long solve(int i, int c, long[] arr, int k, int x) {
        if (c == k) return 0;

        if (i >= arr.length) return Long.MAX_VALUE / 2;

        if (dp[i][c] != null) return dp[i][c];

        long take = arr[i] + solve(i + x, c + 1, arr, k, x);
        long skip = solve(i + 1, c, arr, k, x);

        return dp[i][c] = Math.min(take, skip);
    }

    void add(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int v) {
        int count = map.get(v);

        if (count == 1)
            map.remove(v);
        else
            map.put(v, count - 1);
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        if ((long) n < (long) x * k) return -1;

        int m = n - x + 1;

        long[] mincost = new long[m];
        dp = new Long[m][k + 1];

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int ls = 0, rs = 0;
        long leftsum = 0, rightsum = 0;

        int target = (x + 1) / 2;

        // Build complete first window WITHOUT balancing
        for (int i = 0; i < x; i++) {
            add(left, nums[i]);
            ls++;
            leftsum += nums[i];
        }

        // Balance first window
        while (ls > target) {
            int val = left.lastKey();

            remove(left, val);
            ls--;
            leftsum -= val;

            add(right, val);
            rs++;
            rightsum += val;
        }

        // First window cost
        long median = left.lastKey();

        mincost[0] = median * ls - leftsum
                   + rightsum - median * rs;

        // Sliding window
        for (int i = x; i < n; i++) {

            int out = nums[i - x];

            // Remove outgoing element
            if (left.containsKey(out)) {
                remove(left, out);
                ls--;
                leftsum -= out;
            } else {
                remove(right, out);
                rs--;
                rightsum -= out;
            }

            // Add incoming element
            int in = nums[i];

            if (left.isEmpty()) {
                if (right.isEmpty() || in <= right.firstKey()) {
                    add(left, in);
                    ls++;
                    leftsum += in;
                } else {
                    add(right, in);
                    rs++;
                    rightsum += in;
                }
            } else if (in <= left.lastKey()) {
                add(left, in);
                ls++;
                leftsum += in;
            } else {
                add(right, in);
                rs++;
                rightsum += in;
            }

            // Restore partition sizes
            while (ls > target) {
                int val = left.lastKey();

                remove(left, val);
                ls--;
                leftsum -= val;

                add(right, val);
                rs++;
                rightsum += val;
            }

            while (ls < target) {
                int val = right.firstKey();

                remove(right, val);
                rs--;
                rightsum -= val;

                add(left, val);
                ls++;
                leftsum += val;
            }

            // Calculate window cost
            median = left.lastKey();

            mincost[i - x + 1] =
                    median * ls - leftsum
                    + rightsum - median * rs;
        }

        return solve(0, 0, mincost, k, x);
    }
}
