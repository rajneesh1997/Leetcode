class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c != ']'){
                stack.push(c);
            } else {
                if(c == ']'){
                    String wrd = "", num = "";
                    while(!stack.isEmpty() && stack.peek() >= 'a' && stack.peek() <= 'z'){
                        wrd = stack.pop() + wrd;
                    }
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }
                    while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                        num = stack.pop() + num;
                    }
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }
                    int itr = 0;
                    if(num != ""){
                        itr = Integer.parseInt(num);
                    }
                    while(itr-- > 0){
                        int size = wrd.length();
                        int j = 0;
                        while(j < size){
                            stack.push(wrd.charAt(j++));
                        }
                    }
                }
            }
        }
        String ans = "";
        while(!stack.isEmpty())
            ans = stack.pop() + ans;
        return ans;
    }
}