class Solution {
    int size;
    int ans = 0;
    public int totalNQueens(int n) {
        size = n;
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return ans;
    }
    
    public void backtrack(int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> adiags){
        if(row == size){
            ans++;
            return;
        }
        for(int col = 0; col < size; col++){
            int diag = row - col;
            int adiag = row + col;
            
            if(cols.contains(col) || diags.contains(diag) || adiags.contains(adiag))
                continue;
            
            cols.add(col);
            diags.add(diag);
            adiags.add(adiag);
            
            backtrack(row+1, cols, diags, adiags);
            
            cols.remove(col);
            diags.remove(diag);
            adiags.remove(adiag);
        }
    }
}