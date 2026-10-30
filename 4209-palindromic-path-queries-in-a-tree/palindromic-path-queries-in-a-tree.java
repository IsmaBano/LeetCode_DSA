class Solution {
    int n;
    List<Integer> map[];
    int time=0;
    int intime[];
    int outime[];
    int eulertour[];
    int table[][];
    int col;
    int seg[];
    int N;
    int depth[];
  public int lca(int a,int b){
   if(depth[a]<depth[b]){
    int temp=a;
    a=b;
    b=temp;
   }
   int k=depth[a]-depth[b];
   for(int j=0;j<col;j++){
    if((k&(1<<j))!=0){
        a=table[a][j];
    }
   }
   if(a==b){
    return a;
   }
   for(int j=col-1;j>=0;j--){
    if(table[a][j]!=table[b][j]){
        a=table[a][j];
        b=table[b][j];
    }
   }
   return table[a][0];
  }

    public void dfs(int curr,int par,String s,int d){
        int val=s.charAt(curr)-'a';
        table[curr][0]=par;
        depth[curr]=d;
        eulertour[time]=1<<val;
        intime[curr]=time;
        time++;
        for(int des:map[curr]){
            if(des!=par){
                dfs(des,curr,s,d+1);
            }
        }
        eulertour[time]=1<<val;
        outime[curr]=time;
        time++;
    }
    public void buildsegment(int i,int l,int r){
        if(l==r){
            seg[i]=eulertour[l];
            return;
        }
        int mid=(l+r)/2;
        buildsegment(2*i+1,l,mid);
        buildsegment(2*i+2,mid+1,r);
        seg[i]=seg[2*i+1]^seg[2*i+2];
    }
    public void update(int i,int l,int r,int idx,int val){
        if(l==r){
            seg[i]=val;
            return;
        }
        int mid=(l+r)/2;
        if(idx<=mid){
          update(2*i+1,l,mid,idx,val);
        }else{
          update(2*i+2,mid+1,r,idx,val);
        }
        seg[i]=seg[2*i+1]^seg[2*i+2];
    }
    public int qwery(int i,int l,int r,int ql,int qr){
        if(l>qr ||r<ql){
            return 0;
        }
        if(l>=ql && r<=qr){
            return seg[i];
        }
        int mid=(l+r)/2;
        int left=qwery(2*i+1,l,mid,ql,qr);
        int right=qwery(2*i+2,mid+1,r,ql,qr);
        return left^right;
    }
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Boolean> ans=new ArrayList<>();
        this.n=n;
        map=new ArrayList[n];
        depth=new int[n];
        char arr[]=s.toCharArray();
        for(int i=0;i<n;i++){
            map[i]=new ArrayList<>();
        }
        for(int d[]:edges){
            map[d[0]].add(d[1]);
            map[d[1]].add(d[0]);
        }
        intime=new int[n];
        outime=new int[n];
        eulertour=new int[2*n];
        col=(31 - Integer.numberOfLeadingZeros(n)) + 1;
       table=new int[n][col];
       N=2*n;
       seg=new int[4*N];
       dfs(0,-1,s,0);
       buildsegment(0,0,N-1);
        for(int j=1;j<col;j++){
            for(int node=0;node<n;node++){
                if(table[node][j-1]!=-1){
                table[node][j]=table[table[node][j-1]][j-1];
                }
            }
        }
       for(String q:queries){
         String parts[]=q.split(" ");
           String type=parts[0];
           if(type.equals("update")){
              int node=Integer.parseInt(parts[1]);
              int val=1<<(parts[2].charAt(0)-'a');
              arr[node]=parts[2].charAt(0);
              update(0,0,N-1,intime[node],val);
              update(0,0,N-1,outime[node],val);
           }else{
             int a=Integer.parseInt(parts[1]);
             int b=Integer.parseInt(parts[2]);
             int lcanode=lca(a,b);
             int xor=qwery(0,0,N-1,0,intime[a])^qwery(0,0,N-1,0,intime[b])^(1<<(arr[lcanode]-'a'));
              if((xor&(xor-1))==0){
                ans.add(true);
              }else{
                ans.add(false);
              }
           }
       }
       return ans;
    }
}