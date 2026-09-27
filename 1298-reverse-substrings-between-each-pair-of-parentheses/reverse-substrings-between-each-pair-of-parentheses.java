class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character> st=new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch==')'){
                StringBuilder sb=new StringBuilder();
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                if(!st.isEmpty()){
                    st.pop();
                }
                for(int j=0;j<sb.length();j++){
                    st.push(sb.charAt(j));
                }
            }else{
                st.push(ch);
            }
        }

        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+""+ans;
        }
        return ans;
    }
}