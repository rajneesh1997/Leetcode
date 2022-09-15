class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int[] row : updates){
            int first = row[0];
            int second = row[1];
            int inc = row[2];
            arr[first] += inc;
            if(second+1 < length)
                arr[second+1] -= inc;
        }   
        for(int i = 1; i < length; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        
        return arr;
    }
}