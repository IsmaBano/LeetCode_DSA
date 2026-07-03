class Solution {
    public boolean solve(int val,List<int[]> graph[],boolean[] online, long k){
        int n=online.length;
         PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[2],b[2]));
         long dis[]=new long[n];
         Arrays.fill(dis,Long.MAX_VALUE);
         dis[0]=0;
         pq.add(new long[]{0,Integer.MAX_VALUE,0});
         while(!pq.isEmpty()){
        long node[]=pq.poll();
        int u=(int)node[0];
        long min=node[1];
        if(min<val){
            continue;
        }
        long cost=node[2];
        if(cost>k || dis[u]<cost){
            continue;
        }
        if(u==n-1){
            return true;
        }
          for(int des[]:graph[u]){
            if(des[1]<val){
                continue;
            }
            if(online[des[0]] && dis[des[0]]>cost+des[1]){
                dis[des[0]]=cost+des[1];
            pq.add(new long[]{des[0],Math.min(min,des[1]),cost+des[1]});
            }
          }
      }
      return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;
      List<int[]> graph[]=new ArrayList[n];
      for(int i=0;i<n;i++){
        graph[i]=new ArrayList<>();
      }
      for(int i=0;i<edges.length;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int cst=edges[i][2];
        graph[u].add(new int[]{v,cst});
      }
     if(!online[0] ||!online[n-1]){
        return -1;
      }
      int ans=-1;
      int l=0;
      int r=(int)(1e9);
      while(l<=r){
        int mid=(l+r)/2;
        if(solve(mid,graph,online,k)){
            ans=mid;
            l=mid+1;
        }else{
            r=mid-1;
        }
      }
     return ans;
    }
}