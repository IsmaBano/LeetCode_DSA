class Solution {
    public boolean sorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1)){
                return false;
            }
        }
     return true;
    }
    public int minOperations(String s) {
        if(sorted(s)){
            return 0;
        }else{
            char minchar=s.charAt(0);
            int minidx=0;
            char maxchar=s.charAt(0);
            int maxidx=0;
            for(int i=1;i<s.length();i++){
                if(s.charAt(i)<minchar){
                    minchar=s.charAt(i);
                    minidx=i;
                }
                 if(s.charAt(i)>=maxchar){
                    maxchar=s.charAt(i);
                    maxidx=i;
                }
            }
            if(minidx==0 || maxidx==s.length()-1){
                return 1;
            }else if(s.length()==2){
                return -1;
            }else{
                for(int i=1;i<s.length()-1;i++){
                    if(s.charAt(i)==minchar || s.charAt(i)==maxchar){
                        return 2;
                    }
                }
                return 3;
            }
        }
    }
}