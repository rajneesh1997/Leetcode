class Solution {
    int[] dir = new int[]{0,-1,0,1,0};
    public void dfs(char[][] grid, int sr, int sc){
        if(sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length)
            return;
        if(grid[sr][sc] == '1'){
            grid[sr][sc] = '0';
        } else {
            return;
        }
        for(int i = 0; i < 4; i++){
            int r = dir[i], c = dir[i+1];
            dfs(grid,sr+r,sc+c);
        }
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
}