class Solution {
public:
    void checkArea(vector<vector<char>>& grid,int row,int column){
        if(row<0 || row>=grid.size() || column<0 || column>=grid[0].size()) return;
        if(grid[row][column] == '0') return;
        grid[row][column]='0';
        checkArea(grid,row+1,column);
        checkArea(grid,row-1,column);
        checkArea(grid,row,column+1);
        checkArea(grid,row,column-1);
    }
    int numIslands(vector<vector<char>>& grid) {
        int islands = 0;
        for(int row = 0; row < grid.size(); row++){
            for(int column = 0; column < grid[0].size(); column++){
                if(grid[row][column] == '1'){
                    islands++;
                    checkArea(grid,row,column);
                }
            }
        }
        return islands;
    }
};