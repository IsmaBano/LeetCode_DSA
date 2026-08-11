class Solution {
    public void nextPermutation(int[] a) {
       // 1 2 4 3 2    1 3 2 2 4
        int idx=-1;
        int n=a.length;
        for(int i=n-2;i>=0;i--){
            if(a[i]<a[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            Arrays.sort(a);
            return;
        }
        for(int i=n-1;i>=idx;i--){
            if(a[i]>a[idx]){
                int temp=a[idx];
                a[idx]=a[i];
                a[i]=temp;
                break;
            }
        }
        // sort and add
        List<Integer> list=new ArrayList<>();
        for(int i=idx+1;i<n;i++){
            list.add(a[i]);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            a[idx+i+1]=list.get(i);
        }
    }
}