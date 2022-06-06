class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        for(int i = 1; i <= n; i++){
            dist[i] = Integer.MAX_VALUE/10;
        }
        dist[k] = 0;
        for(int i = 0; i <= n-1; i++){
            for(int[] time:times){
                int u = time[0];
                int v = time[1];
                int w = time[2];
                dist[v] = Math.min(dist[v],dist[u]+w);
            }
        }
        int ans = -1;
        for(int i = 1; i <= n; i++)
            ans = Math.max(ans,dist[i]);
        return ans == Integer.MAX_VALUE/10 ? -1 : ans;
    }
}