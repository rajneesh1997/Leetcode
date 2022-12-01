class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack();
        int n1, n2;
        for(String token : tokens){
            switch (token){
                case "+":
                    n1 = Integer.parseInt(st.peek());
                    st.pop();
                    n2 = Integer.parseInt(st.peek());
                    st.pop();
                    st.push((n2 + n1) + "");
                    break;
                case "-":
                    n1 = Integer.parseInt(st.peek());
                    st.pop();
                    n2 = Integer.parseInt(st.peek());
                    st.pop();
                    st.push((n2 - n1) + "");
                    break;
                case "/":
                    n1 = Integer.parseInt(st.peek());
                    st.pop();
                    n2 = Integer.parseInt(st.peek());
                    st.pop();
                    st.push((n2 / n1) + "");
                    break;
                case "*":
                    n1 = Integer.parseInt(st.peek());
                    st.pop();
                    n2 = Integer.parseInt(st.peek());
                    st.pop();
                    st.push((n2 * n1) + "");
                    break;
                default:
                    st.push(token);
            }
        }
        n1 = Integer.parseInt(st.peek());
        return n1;
    }
}