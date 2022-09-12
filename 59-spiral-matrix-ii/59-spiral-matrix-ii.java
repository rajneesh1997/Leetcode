class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 1;
        int top = 0, bottom = n-1, left = 0, right = n-1;
        while(true){
            for(int k = left; k <= right; k++){
                ans[top][k] = i++;
            }
            if(left > right || top > bottom)
                break;
            
            top++;
            for(int k = top; k <= bottom; k++){
                ans[k][right] = i++;
            }
            if(left > right || top > bottom)
                break;
            
            right--;
            for(int k = right; k >= left; k--){
                ans[bottom][k] = i++;
            }
            if(left > right || top > bottom)
                break;
            
            bottom--;
            for(int k = bottom; k >= top; k--){
                ans[k][left] = i++;
            }
            if(left > right || top > bottom)
                break;
            left++;
            
        }
        return ans;
    }
}