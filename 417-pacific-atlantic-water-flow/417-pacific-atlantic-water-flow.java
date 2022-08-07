class Solution {
    int[] dir = new int[]{0,1,0,-1,0};
    public void dfs(int[][] heights, int i, int j, int curr, boolean[][] set){
        if(set[i][j])
            return;
        set[i][j] = true;
        for(int k = 1; k < dir.length; k++){
            int nr = i + dir[k-1];
            int nc = j + dir[k];
            if(nr > -1 && nr < heights.length && nc > -1 && nc < heights[0].length){
                if(heights[nr][nc] >= curr){
                    dfs(heights, nr, nc, heights[nr][nc], set);
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = heights.length, c = heights[0].length;
        boolean[][] set_p = new boolean[r][c];
        boolean[][] set_a = new boolean[r][c];
        
        int ROW = heights.length;
        int COL = heights[0].length;
        
        for(c = 0 ; c < COL; c++){
            dfs(heights, 0, c, heights[0][c], set_p);
            dfs(heights, ROW-1, c, heights[ROW-1][c], set_a);
        }
        
        for(r = 0; r < ROW; r++){
            dfs(heights,r,0,heights[r][0], set_p);
            dfs(heights,r,COL-1,heights[r][COL-1],set_a);
        }        
        
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(set_a[i][j] && set_p[i][j])
                    ans.add(new ArrayList<Integer>(Arrays.asList(i,j)));
            }
        }
        
        return ans;
    }
}