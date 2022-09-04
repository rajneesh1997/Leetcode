class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i <= n; i++){
            if(i == 0){
                stack.push(i);
            } else {
                while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
                    int ht = heights[stack.pop()];
                    int left = -1;
                    if(!stack.isEmpty()){
                        left = stack.peek();
                    }
                    int right = i;
                    ans = Math.max(ans, ht * (right - left - 1));
                }
                stack.push(i);
            }
        }
        return ans;
    }
}