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
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, largestRectangleArea(dp));
        } 
        return maxarea;
    }
}