class Solution {
    public void dfs1(int curr,List<Integer> graph[],boolean sus[],boolean vis[]){
        if(vis[curr]){
            return;
        }
        
        sus[curr]=true;
        vis[curr]=true;
        for(int des:graph[curr]){
            if(!vis[des]){
                dfs1(des,graph,sus,vis);
            }
        }
    }
     public boolean dfs2(int curr,List<Integer> graph[],boolean sus[],boolean vis[]){
        vis[curr]=true;
        if(sus[curr]){
            return true;
        }
        boolean flag=false;
        for(int des:graph[curr]){
            if(!vis[des]){
               flag=flag| dfs2(des,graph,sus,vis);
            }else{
                flag=flag|sus[des];
            }
        }
        return flag;
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<invocations.length;i++){
            int a=invocations[i][0];
            int b=invocations[i][1];
            graph[a].add(b);
        }
        boolean sus[]=new boolean[n];
        boolean visited[]=new boolean[n];
        dfs1(k,graph,sus,visited);
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                flag=flag|dfs2(i,graph,sus,visited);
                if(flag){
                    break;
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        if(flag){
            for(int i=0;i<n;i++){
             ans.add(i);
            }
        }else{
            for(int i=0;i<n;i++){
                if(!sus[i]){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}