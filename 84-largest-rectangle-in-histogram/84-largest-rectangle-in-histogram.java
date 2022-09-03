class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int ans = Integer.MIN_VALUE;
        int left = 0, right = 0;
        for(int i = 0; i <= n; i++){
            if(i == 0){
                stack.push(i);
            } else {
                while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
                    int height = heights[stack.pop()];
                    if(!stack.isEmpty())
                        left = stack.peek();
                    right = i;
                    if(stack.isEmpty()){
                        ans = Math.max(ans, height * (right));
                    } else {
                        ans = Math.max(ans, height * (right - left - 1));
                    }
                }
                stack.push(i);
            }
        }
        // while(!stack.isEmpty()){
        //     int height = heights[stack.pop()];
        //     if(!stack.isEmpty())
        //         left = stack.peek();
        //     right = n;
        //     if(stack.isEmpty()){
        //         ans = Math.max(ans, height * (right));
        //     } else {
        //         ans = Math.max(ans, height * (right - left - 1));
        //     }
        // }
        return ans;
    }
}