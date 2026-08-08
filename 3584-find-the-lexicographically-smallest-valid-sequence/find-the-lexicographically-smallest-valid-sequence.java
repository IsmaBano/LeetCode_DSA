class Solution {
    public int[] validSequence(String word1, String word2) {
        //left change right 
        /*
            vbcca to  
            left to aa jayega 
            right chahiye 
            if right is present break kar jao isse smallest nhi ho sakta so bas right chahiya
        */
        int n=word1.length();
        int m=word2.length();
        int right[]=new int[m];
        Arrays.fill(right,-1);
        int r=m-1;
        for(int i=n-1;i>=0;i--){
          if(word1.charAt(i)==word2.charAt(r)){
            right[r]=i;
            r--;
          }
          if(r<0){
            break;
          }
        }
        List<Integer> ans=new ArrayList<>();
        int l=0;
        boolean flag=false;
        int idx=n;
        for(int i=0;i<n;i++){
            if(l>=m){
                flag=true;
                idx=i;
                break;
            }
         if(word1.charAt(i)==word2.charAt(l)){
            ans.add(i);
            l++;
            continue;
          }
          int next=l+1;
          if(next>=m || right[next]>i){
             idx=i;
             ans.add(i);
             l++;
             System.out.println(i);
              flag=true;
              break;
          }
        }

       for(int i=idx+1;i<n;i++){
        if(l>=m){
            break;
          }
        if(word1.charAt(i)==word2.charAt(l)){
              System.out.println(i);
            ans.add(i);
            l++;
          }
          
       }
       if(!flag){
        return new int[]{};
       }
       int res[]=new int[ans.size()];
       for(int i=0;i<ans.size();i++){
        res[i]=ans.get(i);
       }
      return res;
    }
}