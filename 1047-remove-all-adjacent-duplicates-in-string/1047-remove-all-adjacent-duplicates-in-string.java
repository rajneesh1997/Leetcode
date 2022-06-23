class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        int i = 0, n = s.length();
        while(i < n){
            char c = s.charAt(i);
            if(stack.size() == 0){
                stack.push(c);
            } else {
                if(stack.peek() != c){
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            i++;
        }
        String ans = "";
        while(stack.size() > 0){
            ans = stack.pop() + ans;
        }
        return ans;
    }
}