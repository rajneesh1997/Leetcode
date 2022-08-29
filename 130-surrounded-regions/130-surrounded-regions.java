class Solution {
    int[] dir = new int[]{0,1,0,-1,0};
    public void dfs(int i, int j, char[][] board, int[][] visited){
        if(i<0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if(board[i][j] == 'X') return;
        if(visited[i][j] == 1) return;
        visited[i][j] = 1;
        for(int k = 1; k < dir.length; k++){
            int nr = i + dir[k-1];
            int nc = j + dir[k];
            dfs(nr,nc,board,visited);
        }
        
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && visited[i][0] == 0){
                dfs(i,0,board,visited);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(board[i][m-1] == 'O' && visited[i][m-1] == 0){
                dfs(i,m-1,board,visited);
            }
        }
        
        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O' && visited[0][i] == 0){
                dfs(0,i,board,visited);
            }
        }
        
        for(int i = 0; i < m; i++){
            if(board[n-1][i] == 'O' && visited[n-1][i] == 0){
                dfs(n-1,i,board,visited);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0)
                    board[i][j] = 'X';
            }
        }
        
    }
}