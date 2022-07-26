class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack();
        String dup_s = "";
        for(char c : s.toCharArray()){
            if(c == '#'){
                if(!stack.isEmpty()){
                    stack.pop();  
                }
            } else {
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            dup_s = stack.pop() + dup_s;
        }
        String dup_t = "";
        for(char c : t.toCharArray()){
            if(c == '#'){
                if(!stack.isEmpty()){
                    stack.pop();  
                }
            } else {
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            dup_t = stack.pop() + dup_t;
        }
        // System.out.println(ans);
        return dup_s.equals(dup_t);
    }
}