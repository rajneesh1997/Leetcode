class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length){
            if(matrix[row][col] < target)
                row++;
            else
                break;
        }
        if(row > matrix.length - 1) return false;
        int left = 0, right = col;
        while(left <= right){
            // System.out.println(left + " "  + right);
            int mid = left + ((right - left) / 2);
            if(matrix[row][mid] == target)
                return true;
            if(matrix[row][mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return false;
    }
}