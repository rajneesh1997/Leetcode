class Solution {
    int[] dir = new int[]{0,1,0,-1,0};
    public boolean f(int i, int j, String word, int n, char[][] board){
        // System.out.println(i + " " + j + " " + n);
        if(word.length() == n)
            return true;
        if(board[i][j] == '1')
            return true;
        char c = board[i][j];
        board[i][j] =  '1';
        // System.out.println(board[i][j]);
        boolean ans = false;
        for(int a = 1; a < dir.length; a++){
            int nr = i + dir[a-1];
            int nc = j + dir[a];
            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length){
                if(board[nr][nc] == word.charAt(n)){
                    
                    ans = ans || f(nr,nc,word,n+1,board);  
                }
            }
        }
        board[i][j] = c;
        // System.out.println(board[i][j]);
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0))
                if(f(i,j,word,1,board))
                    return true;
            }
        }
        return false;
    }
}