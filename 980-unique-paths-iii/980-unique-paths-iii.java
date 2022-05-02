class Solution {
    int ans = 0;
    public void dp(int[][] grid,int total, int x, int i, int j){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1) return;
        if(grid[i][j] == -20) return;
        if(grid[i][j] == 2){
            if(total == x)
                ans++;
            return;
        }
        if(grid[i][j] == -1) return;
        grid[i][j] = -20;
        
        dp(grid,total,x+1,i-1,j);
        dp(grid,total,x+1,i+1,j);
        dp(grid,total,x+1,i,j+1);
        dp(grid,total,x+1,i,j-1);
        
        grid[i][j] = 0;
    }
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int total = 0, x = 0, y = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] != -1 && grid[i][j] != 2) total++;
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
            }
        }
        dp(grid,total,0,x,y);
        return ans;
    }
}