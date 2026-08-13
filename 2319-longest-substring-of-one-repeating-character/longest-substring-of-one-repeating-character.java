class Solution {
    pair seg[];
    public class pair{
        int left;
        int right;
        int leftcnt;
        int rightcnt;
        int cnt[];
        public pair(int left,int right,int leftcnt,int rightcnt){
            this.left=left;
            this.right=right;
            this.leftcnt=leftcnt;
            this.rightcnt=rightcnt;
            cnt=new int[26];
        }
    }  
    public void build(int i,int l,int r,String s){
        if(l==r){
            int ch=s.charAt(l)-'a';
            seg[i]=new pair(ch,ch,1,1);
            seg[i].cnt[ch]=1;
            return;
        }
        int mid=(l+r)/2;
        build(2*i+1,l,mid,s);
        build(2*i+2,mid+1,r,s);
        seg[i]=new pair(seg[2*i+1].left,seg[2*i+2].right,seg[2*i+1].leftcnt,seg[2*i+2].rightcnt);
        for(int j=0;j<26;j++){
            seg[i].cnt[j]=Math.max(seg[2*i+1].cnt[j],seg[2*i+2].cnt[j]);
        }
        if(seg[2*i+1].right==seg[2*i+2].left){
            seg[i].cnt[seg[2*i+1].right]=Math.max(seg[i].cnt[seg[2*i+1].right],seg[2*i+1].rightcnt+seg[2*i+2].leftcnt);
            if(seg[2*i+1].rightcnt==(mid-l+1)){
                seg[i].leftcnt=seg[2*i+1].rightcnt+seg[2*i+2].leftcnt;
            }
            if(seg[2*i+2].leftcnt==(r-mid)){
                seg[i].rightcnt=seg[2*i+1].rightcnt+seg[2*i+2].leftcnt;
            }
        }
    }
    public int find(){
        int ans=0;
        for(int i=0;i<26;i++){
            ans=Math.max(ans,seg[0].cnt[i]);
        }
        return ans;
    }
    public void update(int i,int l,int r,String s,int idx,int val){
         if(l==r){
            seg[i].cnt[seg[i].left]=0;
             seg[i].left=val;
            seg[i].right=val;
            seg[i].cnt[val]=1;
            return;
        }
        int mid=(l+r)/2;
        if(idx<=mid){
        update(2*i+1,l,mid,s,idx,val);
        }else{
        update(2*i+2,mid+1,r,s,idx,val);
        }
        seg[i].left=seg[2*i+1].left;
        seg[i].right=seg[2*i+2].right;
        seg[i].leftcnt=seg[2*i+1].leftcnt;
        seg[i].rightcnt=seg[2*i+2].rightcnt;
        for(int j=0;j<26;j++){
            seg[i].cnt[j]=Math.max(seg[2*i+1].cnt[j],seg[2*i+2].cnt[j]);
        }
        if(seg[2*i+1].right==seg[2*i+2].left){
            seg[i].cnt[seg[2*i+1].right]=Math.max(seg[i].cnt[seg[2*i+1].right],seg[2*i+1].rightcnt+seg[2*i+2].leftcnt);
            if(seg[2*i+1].rightcnt==(mid-l+1)){
                seg[i].leftcnt=seg[2*i+1].rightcnt+seg[2*i+2].leftcnt;
            }
            if(seg[2*i+2].leftcnt==(r-mid)){
                seg[i].rightcnt=seg[2*i+1].rightcnt+seg[2*i+2].leftcnt;
            }
        }
    }
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
       int n=s.length();
       int k=queryCharacters.length();
       seg=new pair[4*n];
       build(0,0,n-1,s);
       int ans[]=new int[k];
       for(int i=0;i<k;i++){
        int val=queryCharacters.charAt(i)-'a';
        int idx=queryIndices[i];
        update(0,0,n-1,s,idx,val);
        ans[i]=find();
       }
       return ans;
    }
}