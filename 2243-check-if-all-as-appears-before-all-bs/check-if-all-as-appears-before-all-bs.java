class Solution {
    public boolean checkString(String s) {
        boolean startb=false;
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                if(startb){
                    return false;
                }
            }else{
                startb=true;
            }
        }
        return true;
    }
}