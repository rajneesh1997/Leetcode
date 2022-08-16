class Solution {
    public void dfs(int[][] isConnected, int i, boolean[] visited){
        if(visited[i])
            return;
        visited[i] = true;
        for(int k = 0; k < isConnected[i].length; k++){
            if(isConnected[i][k] == 1){
                dfs(isConnected,k,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                ans++;
            }
        }
        return ans;
    }
}