class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for(int i = 0; i < row; i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] top = q.poll();
            int d = top[0];
            int r = top[1];
            int c = top[2];
            // if(d > dist[r][c]) continue;
            if(r == row-1 && c == col-1) return d;
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < row && nc < col){
                    int newDist = Math.max(d,Math.abs(heights[nr][nc] - heights[r][c]));
                    if(dist[nr][nc] > newDist){
                        dist[nr][nc] = newDist;
                        q.offer(new int[]{dist[nr][nc],nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}