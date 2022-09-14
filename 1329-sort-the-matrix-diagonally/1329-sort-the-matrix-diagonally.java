class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        // if(col == 1)
        //     return mat;
        // if(row == 1)
        //     return mat;
        
        for(int k = 1 - row; k < col; k++){
            ArrayList<Integer> arr = new ArrayList<>();
             if(k < 0){
                 for(int j = 0, i = j - k; i < row && j < col; j = j + 1, i = j - k){
                     arr.add(mat[i][j]);
                 }
                 
                 Collections.sort(arr);
                 int itr = 0;
                 for(int j = 0, i = j - k; i < row && j < col; j = j + 1, i = j - k){
                     mat[i][j] = arr.get(itr++);
                 }
             } else {
                 for(int i = 0, j = i + k; i < row && j < col; i = i + 1, j = i + k){
                     arr.add(mat[i][j]);
                 }
                 
                 Collections.sort(arr);
                 int itr = 0;
                 for(int i = 0, j = i + k; i < row && j < col; i = i + 1, j = i + k){
                     mat[i][j] = arr.get(itr++);
                 }
             }
        }
        
        
        return mat;
    }
}