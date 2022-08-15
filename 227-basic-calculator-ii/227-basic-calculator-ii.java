class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int currentNumber = 0;
        char operation = '+';
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            if(!Character.isWhitespace(c) && !Character.isDigit(c) || i == len - 1){
                if(operation == '-')
                    stack.push(-currentNumber);
                else if(operation == '+')
                    stack.push(currentNumber);
                else if(operation == '*')
                    stack.push(stack.pop() * currentNumber);
                else if(operation == '/')
                    stack.push(stack.pop() / currentNumber);
                operation = c;
                currentNumber = 0;
            }
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}