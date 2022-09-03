class Solution {
    Stack<Integer> stack = new Stack<>();
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i == 0){
                stack.push(i);
                left[i] = i;
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    left[i] = 0;
                } else {
                    left[i] = stack.peek() + 1;
                }
                stack.push(i);
            }
        }
        
        stack.clear();
        
        for(int i = n-1; i > -1; i--){
            if(i ==  n-1){
                stack.push(i);
                right[i] = n-1;
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    right[i] = n-1;
                } else {
                    right[i] = stack.peek() - 1;
                }
                stack.push(i);
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
        }
        
        return ans;
    }
}