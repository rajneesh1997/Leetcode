class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        int i = -1;
        while(i < s.length() - 1){
            ++i;
            char c = s.charAt(i);
            if(st.empty() || c == '(' || c == '[' || c == '{'){
                st.push(c);
            }
            else{
                if((c == ')' && st.peek() == '(') || (c == ']' && st.peek() == '[') || (c == '}' && st.peek() == '{')) 
                    st.pop();
                else 
                    return false;
            }
        }
        return st.empty();
    }
}