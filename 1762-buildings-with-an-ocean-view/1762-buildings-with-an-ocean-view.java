class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        for(int i = n-1; i > -1; i--){
            if(i == n-1){
                stack.push(i);
            } else if(heights[i] > heights[stack.peek()]){
                stack.push(i);
            }
        }
        int siz = stack.size();
        int[] ans = new int[siz];
        int it = 0;
        while(!stack.isEmpty()){
            ans[it++] = stack.pop();
        }
        return ans;
    }
}