class Solution {
    int ans = -1;
    int[] dir = new int[]{0,1,0,-1,0};
    public int orangesRotting(int[][] grid) {
        LinkedList<int[][]> queue = new LinkedList();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2)
                    queue.offer(new int[][]{{i,j}});
            }
        }
        while(!queue.isEmpty()){
            ans++;
            int size = queue.size();
            for(int i = 1; i <= size; i++){
                int[][] cell = queue.poll();
                // System.out.println(cell[0][0] + " " + cell[0][1]);
                for(int j = 1; j < dir.length; j++){
                    int row = cell[0][0] + dir[j-1];
                    int col = cell[0][1] + dir[j];
                    if(row > -1 && row < grid.length && col > -1 && col < grid[0].length){
                        if(grid[row][col] == 1){
                            grid[row][col] = 2;
                            queue.add(new int[][]{{row,col}});
                        }
                    }
                }
            }
        }
        for(int[] row : grid){
            for(int cell : row){
                if(cell == 1)
                    return -1;
            }
        }
        return ans == -1 ? 0 : ans;
    }
}