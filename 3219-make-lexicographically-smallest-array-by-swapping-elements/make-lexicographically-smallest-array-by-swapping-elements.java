class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
         int n=nums.length;
      //group banayenge group ke andar sort kar denge wahi answer ho jayega
      // group 1 index values
      int arr[][]=new int[n][2];
      for(int i=0;i<n;i++){
         arr[i][0]=nums[i];
         arr[i][1]=i;
      }
      Arrays.sort(arr,(a,b)->a[0]-b[0]);
      HashMap<Integer,List<Integer>> map1=new HashMap<>(); // stores values
      HashMap<Integer,List<Integer>> map2=new HashMap<>();
      int grp=1;
      int prev=-1;
      for(int i=0;i<n;i++){
          if(prev==-1 || (prev+limit<arr[i][0])){
            grp++;
          }
          if(!map1.containsKey(grp)){
            map1.put(grp,new ArrayList<>());
            map2.put(grp,new ArrayList<>());
          }
          map1.get(grp).add(arr[i][0]);
          map2.get(grp).add(arr[i][1]);
          prev=arr[i][0];
          System.out.println(prev+" "+grp);
      }
    int ans[]=new int[n];
      for(Integer key:map1.keySet()){
        List<Integer> temp=map2.get(key);
        List<Integer> val=map1.get(key);
        Collections.sort(temp);
        for(int i=0;i<temp.size();i++){
         ans[temp.get(i)]=val.get(i);
        }
      }

     return ans;
    }
}