class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            graph[u].add(new int[]{v,wt});
        }
        //node wt prevchar cnt 
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0,labels.charAt(0)-'a',1});
        int dis[][]=new int[n][k+1];
        for(int i=0;i<n;i++){
                Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dis[0][1]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int node=cur[0];
            int wt=cur[1];
            int pre=cur[2];
            int cnt=cur[3];
            if(dis[node][cnt]!=wt){
                continue;
            }
            for(int d[]:graph[node]){
                int v=d[0];
                int w=d[1];
                int nc=cnt;
                int c=labels.charAt(v)-'a';
                if(pre==c){
                    nc++;
                }else{
                    nc=1;
                }
                if(nc<=k){
                    if(dis[v][nc]>dis[node][cnt]+w){
                       dis[v][nc]=dis[node][cnt]+w;
                        pq.add(new int[]{v,dis[v][nc],c,nc});
                    }
                }
            }

        }
        int ans=Integer.MAX_VALUE;
            for(int i=0;i<=k;i++){
                ans=Math.min(ans,dis[n-1][i]);
            }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}