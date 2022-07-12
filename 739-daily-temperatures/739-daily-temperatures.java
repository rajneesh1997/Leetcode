class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int size = temperatures.length;
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int j = stack.pop();
                ans[j] = i-j;
            }
            stack.push(i);
        }
        return ans;
    }
}