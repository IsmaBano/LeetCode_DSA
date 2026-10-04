class Solution {
    public boolean checkValidString(String s) {
       /*
    
       */
       int cnt=0;
       int c=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                cnt++;
            }else if(ch==')'){
                cnt--;
            }else{
                c++;
            }
            if(cnt<0){
                if(c<Math.abs(cnt)){
                    return false;
                }else{
                    c-=Math.abs(cnt);
                    cnt=0;
                }
            }
        }
        cnt=0;
        c=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch==')'){
                cnt++;
            }else if(ch=='('){
                cnt--;
            }else{
                c++;
            }
            if(cnt<0){
                if(c<Math.abs(cnt)){
                    return false;
                }else{
                    c-=Math.abs(cnt);
                    cnt=0;
                }
            }
        }
        return true;
        
    }
}