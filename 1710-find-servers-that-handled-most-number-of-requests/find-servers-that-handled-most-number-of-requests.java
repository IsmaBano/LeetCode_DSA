class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int cnt[]=new int[k];
        TreeSet<Integer> free=new TreeSet<>();
        PriorityQueue<int[]> busy=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n=arrival.length;
        int max=-1;
        for(int i=0;i<k;i++){
            free.add(i);
        }

        for(int i=0;i<n;i++){
            int time=arrival[i];
            while(!busy.isEmpty() && busy.peek()[0]<=time){
                free.add(busy.poll()[1]);
            }
            Integer ser=free.ceiling(i%k);
            if(ser==null && !free.isEmpty()){
                ser=free.first();
            }
            if(ser!=null){
                int sr=(int)ser;
                free.remove(ser);
                busy.add(new int[]{time+load[i],sr});
                cnt[sr]++;
                 max=Math.max(max,cnt[sr]);
            }
            
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            if(cnt[i]==max){
                ans.add(i);
            }
        }

      return ans;
    }
}