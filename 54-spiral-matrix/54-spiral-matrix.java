class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int num_of_elements = matrix.length * matrix[0].length;
        int count = 0;
        ArrayList<Integer> ans = new ArrayList();
        int col = 0, row = 0;
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        // System.out.println(num_of_elements);
        while(true){
            for(int i = col; i <= m; i++){
                count++;
                ans.add(matrix[row][i]);
            }
            row++;
            if(col > m || row > n) break;
            
            for(int i = row; i <= n; i++){
                count++;
                ans.add(matrix[i][m]);
            }
            --m;
            if(col > m || row > n) break;
        
            for(int i = m; i >= col; i--){
                count++;
                ans.add(matrix[n][i]);
            }
            --n;
            if(col > m || row > n) break;
        
            for(int i = n; i >= row; i--){
                count++;
                ans.add(matrix[i][col]);
            }
            ++col;   
            if(col > m || row > n) break;
            
        }
        return ans;
    }
}