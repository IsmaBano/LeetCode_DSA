class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int ans=0;
        while(r<n){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(l<r && map.get(ch)>2){
              char ch2=s.charAt(l);
              int val=map.get(ch2)-1;
              if(val>0){
               map.put(ch2,val);
              }else{
                map.remove(ch2);
              }
              l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
      return ans;
    }
}