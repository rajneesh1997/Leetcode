class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] d : dist){
            Arrays.fill(d,Integer.MAX_VALUE/1000);
        }
        for(int i = 0; i < n; i++){
            dist[i][i] = 0;
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = dist[v][u] = w;
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        // for(int[] i : dist){
        //     for(int j : i)
        //         System.out.print(j + " ");
        //     System.out.println();
        // }
        int ans = 0, minSize = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j : dist[i]){
                if(j != 0 && j <= distanceThreshold)
                    count++;
            }
            if(minSize >= count){
                minSize = count;
                ans = i;
            }
        }
        return ans;
    }
}