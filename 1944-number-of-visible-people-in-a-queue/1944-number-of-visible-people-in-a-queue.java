class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        int[] ans = new int[n];
        for(int i = n-1; i > -1; i--){
            int count = 0;
            while(stack.peek() != n && heights[stack.peek()] < heights[i]){
                count++;
                stack.pop();
            }
            
            if(stack.peek() == n)
                ans[i] = count;
            else
                ans[i] = count + 1;
            stack.push(i);
        }
        return ans;
    }
}