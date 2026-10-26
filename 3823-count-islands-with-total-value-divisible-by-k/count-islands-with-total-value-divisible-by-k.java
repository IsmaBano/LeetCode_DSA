class Solution {
    public boolean valid(int x,int y,int [][]grid){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){
            return false;
        }
        return true;
    }
    public long solve(int i,int j,boolean visited[][],int grid[][]){
          if(visited[i][j]){
            return 0;
          }
          visited[i][j]=true;
          long sum=grid[i][j];
          int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
          for(int d[]:dir){
            int nx=i+d[0];
            int ny=j+d[1];
            if(valid(nx,ny,grid) && grid[nx][ny]!=0){
                sum+=solve(nx,ny,visited,grid);
            }
          }
          return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int cnt=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    long sum=solve(i,j,visited,grid);
                    if(sum%k==0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}