class Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] =  '.';
            }
        }
        
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        return solutions;
    }
    
    public void backtrack(int ind, Set<Integer> cols, Set<Integer> diags, Set<Integer> antidiags, char[][] board){
        if(ind == size){
            solutions.add(createBoard(board));
            return;
        }
        
        for(int col = 0; col < size; col++){
            int diag = ind - col;
            int antidiag = ind + col;
            
            if(diags.contains(diag) || antidiags.contains(antidiag) || cols.contains(col))
                continue;
            
            board[ind][col] = 'Q';
            cols.add(col);
            diags.add(diag);
            antidiags.add(antidiag);
            
            backtrack(ind+1,cols,diags,antidiags,board);
            
            board[ind][col] = '.';
            cols.remove(col);
            diags.remove(diag);
            antidiags.remove(antidiag);
        }
    }
    
    public List<String> createBoard(char[][] board){
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String str = new String(board[i]);
            ans.add(str);
        }
        
        return ans;
    }
}