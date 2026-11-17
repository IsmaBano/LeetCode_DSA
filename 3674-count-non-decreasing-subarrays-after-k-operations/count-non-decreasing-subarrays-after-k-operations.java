class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long ans=0;
        int n=nums.length;
        long psum[]=new long[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+nums[i];
        }
       int nge[]=new int[n];
       Stack<Integer> st=new Stack<>();
       for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && nums[st.peek()]<nums[i]){
            st.pop();
        }
        if(st.isEmpty()){
            nge[i]=n;
        }else{
            nge[i]=st.peek();
        }
        st.push(i);
       }

      long op[]=new long[n+1];
      for(int i=n-1;i>=0;i--){
        int m=nge[i];
        long seg=((m-i)*1L*nums[i])-(psum[m]-psum[i])+op[m];
        op[i]=seg;
      }
        Deque<Integer> dq=new ArrayDeque<>();
        int i=0;
        int j=0;
        while(j<n){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j]){
                dq.removeLast();
            }
            dq.addLast(j);
            while(i<=j){
                int m=dq.peekFirst();
                long optn=op[i]-op[m]+ (1L*nums[m]*(j-m+1)-(psum[j+1]-psum[m]));
                if(optn<=k){
                    break;
                }
                i++;
                if(dq.peekFirst()<i){
                    dq.removeFirst();
                }
            }
            ans+=(j-i+1);
           j++;
        }
       return ans;


    }
}