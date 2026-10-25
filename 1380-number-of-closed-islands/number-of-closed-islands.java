class Solution {
    public void dfs(int i,int j,int[][] grid,boolean [][] visited){
        if(visited[i][j]){
            return ;
        }
        visited[i][j]=true;
        int dir[][]={{0,-1},{0,1},{1,0},{-1,0}};
        for(int d=0;d<4;d++){
            int ni=dir[d][0]+i;
             int nj=dir[d][1]+j;
            if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj]!=1){
                dfs(ni,nj,grid,visited);
            }
        }
        
        
    }
    public int closedIsland(int[][] grid) {
        boolean [][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0 ){
                dfs(i,0,grid,visited);
            }
            if(grid[i][grid[0].length-1]==0 ){
                dfs(i,grid[0].length-1,grid,visited);
            }
        }
         for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==0 ){
                dfs(0,i,grid,visited);
            }
            if(grid[grid.length-1][i]==0 ){
                dfs(grid.length-1,i,grid,visited);
            }
        }
        int c=0;
        for(int i=1;i<grid.length-1;i++){
            for(int j=1;j<grid[0].length-1;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    c++;
                }
            }
        }
        return c;
    }
}