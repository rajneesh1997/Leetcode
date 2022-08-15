class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids){
            if(stack.isEmpty() || (stack.peek() < 0 && ast < 0 ) || (stack.peek() > 0 && ast > 0)){
                stack.push(ast);
            } else {
                boolean left = false, right = false, toAdd = true;
                if(stack.peek() > 0) right = true;
                if(ast < 0) left = true;
                while(!stack.isEmpty() && left && right){
                    if(!stack.isEmpty() && Math.abs(ast) == Math.abs(stack.peek())){
                        stack.pop();
                        toAdd = false;
                        break;
                    } else {
                        if(!stack.isEmpty() && Math.abs(ast) > stack.peek()){
                            stack.pop();
                            if(!stack.isEmpty() && stack.peek() < 0) right = false;
                        } else {
                            toAdd = false;
                            break;
                        }
                    }
                }
                if(toAdd){
                    stack.add(ast);
                }
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for(int i = size - 1; i > -1; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}