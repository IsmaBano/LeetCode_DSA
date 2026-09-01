class Solution {
    public int minMoves(String[] classroom, int energy) {
         int n=classroom.length;
         int m=classroom[0].length();
         int sx=-1;
         int sy=-1;
         int cnt=0;
         int pos[][]=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=classroom[i].charAt(j);
                if(ch=='S'){
                    sx=i;
                    sy=j;
                }else if(ch=='L'){
                  pos[i][j]=1<<cnt;
                  cnt++;
                }
            }
         }
         int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
         
         int totmask=(1<<cnt)-1;
         int best[][][]=new int[n][m][totmask+1];
         for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        Arrays.fill(best[i][j], -1);
    }
}
         Queue<int[]> q=new LinkedList<>();
         q.add(new int[]{sx,sy,0,energy});   //x,y,mask,energy
         best[sx][sy][0]=energy;
         int steps=0;
         while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
          int node[]=q.poll();
           if(node[2]==totmask){
                return steps;
            }
             if(node[3]<=0){
            continue;
          }
          
            for(int d[]:dir){
                int nx=node[0]+d[0];
                int ny=node[1]+d[1];
                if(nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;
                }
                
                char ch=classroom[nx].charAt(ny);
                if(ch=='X'){
                    continue;
                }
                int newmask=node[2]|pos[nx][ny];
                int newenergy=node[3]-1;
                if(ch=='R'){
                    newenergy=energy;
                }
                if(best[nx][ny][newmask]>=newenergy){
                    continue;
                }
                best[nx][ny][newmask]=newenergy;
                 q.add(new int[]{nx,ny,newmask,newenergy});
            }
            
            }
            steps++;
         }
         return -1;
    }
}