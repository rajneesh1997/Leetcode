class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList();
        int col = 0, row = 0;
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        // System.out.println(num_of_elements);
        while(true){
            for(int i = col; i <= m; i++){
                ans.add(matrix[row][i]);
            }
            row++;
            if(col > m || row > n) break;
            
            for(int i = row; i <= n; i++){
                ans.add(matrix[i][m]);
            }
            --m;
            if(col > m || row > n) break;
        
            for(int i = m; i >= col; i--){
                ans.add(matrix[n][i]);
            }
            --n;
            if(col > m || row > n) break;
        
            for(int i = n; i >= row; i--){
                ans.add(matrix[i][col]);
            }
            ++col;   
            if(col > m || row > n) break;
            
        }
        return ans;
    }
}