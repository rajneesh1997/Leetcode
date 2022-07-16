class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m-1, c = 0;
        int ans = 0;
        while(r > -1 && c < n){
            if(grid[r][c] < 0){
                ans += n - c;
                --r;
            } else {
                ++c;
            }
        }
        return ans;
    }
}