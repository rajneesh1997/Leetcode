class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int j = 1; j < grid.length; j++){
            grid[j][0] += grid[j-1][0];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        // for(int[] r:grid){
        //     for(int c:r){
        //         System.out.print(c+" ");
        //     }
        //     System.out.println();
        // }
        int r = grid.length, c = grid[0].length;
        return grid[r-1][c-1];
    }
}