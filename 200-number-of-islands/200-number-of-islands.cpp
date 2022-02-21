class Solution {
public:
    vector<vector<int>> directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    int dfs(vector<vector<char>>& grid, vector<vector<bool>>& visited,int row, int col){
        int m = grid.size();
        int n = grid[0].size();
        if(row<0 || row>=m || col<0 || col>=n) return 0;
        if(visited[row][col] || grid[row][col]=='0') return 0;
        visited[row][col] = true;
        for(auto cnt : directions){
            dfs(grid,visited,row+cnt[0],col+cnt[1]);
        }
        return 1;
    }
    int numIslands(vector<vector<char>>& grid) {
        int islands=0;
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited = vector(m,vector(n,false));
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] and grid[i][j]=='1'){
                    if(dfs(grid,visited,i,j))
                        islands++;
                }
            }
        }
        return islands;
    }
};