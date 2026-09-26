class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }
        StringBuilder ans=new StringBuilder();
        String val="";
        boolean flag=true;
        for(char ch:s.toCharArray()){
           if(ch=='('){
             flag=false;
           }else if(ch==')'){
            if(map.containsKey(val)){
                ans.append(map.get(val));
            }else{
                ans.append('?');
            }
            val="";
            flag=true;
           }else{
            if(flag){
                ans.append(ch);
            }else{
                val=val+""+ch;
            }
           }
        }
        return ans.toString();
    }
}