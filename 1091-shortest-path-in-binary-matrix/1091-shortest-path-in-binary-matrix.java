class Solution {
    int[][] dist = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if(row == n-1 && col == n-1)
                return distance;
            for(int[] next : getNext(row,col,grid)){
                int nRow = next[0];
                int nCol = next[1];
                queue.add(new int[]{nRow, nCol});
                grid[nRow][nCol] = distance + 1;
            }
        }
        return -1;
    }
    public List<int[]> getNext(int row, int col, int[][] grid){
        int n = grid.length;
        List<int[]> arr = new ArrayList<>();
        for(int[] cell : dist){
            int nRow = row + cell[0];
            int nCol = col + cell[1];
            if(nRow < 0 || nCol < 0 || nRow >= n || nCol >= n || grid[nRow][nCol] != 0)
                continue;
            arr.add(new int[]{nRow, nCol});
        }
        return arr;
    }
}