class Solution {
    public int scoreOfParentheses(String s) {
       
        Stack<Integer> st=new Stack<>();
        
        //(=-1
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(-1);
            }else{
                int scr=0;
                while(!st.isEmpty() && st.peek()!=-1){
                    scr+=st.pop();
                }
                
               st.pop();
                if(scr==0){
                  st.push(1);
                }else{
                st.push(scr*2);
                }
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}