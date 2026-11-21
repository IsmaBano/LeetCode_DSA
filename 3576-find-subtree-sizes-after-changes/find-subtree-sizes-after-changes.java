class Solution {
   int parent[];
   int ans[];
   int last[];
   public void dfs(int curr,String s,List<Integer> tree[]){
    int chr=s.charAt(curr)-'a';
    int prelast=last[chr];
    last[chr]=curr;
    for(int ch:tree[curr]){
        dfs(ch,s,tree);
    }
    last[chr]=prelast;
    if(curr!=0){
     int newpar=parent[curr];
    if(prelast!=-1){
        newpar=prelast;
    }
    ans[newpar]+=ans[curr];
    parent[curr]=newpar;
    }
   }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=s.length();
        List<Integer> tree[]=new ArrayList[n];
        last=new int[26];
        Arrays.fill(last,-1);
        ans=new int[n];
        Arrays.fill(ans,1);
         this.parent=parent;
         for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
         }
         for(int i=0;i<n;i++){
            if(parent[i]!=-1){
                tree[parent[i]].add(i);
            }
         }
         dfs(0,s,tree);
         return ans;
    }
}