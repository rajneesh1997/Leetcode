class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length; k++){
                    int val1 = Math.abs(arr[i]-arr[j]);
                    int val2 = Math.abs(arr[j]-arr[k]);
                    int val3 = Math.abs(arr[i]-arr[k]);
                    if(val1 <= a && val2 <= b && val3 <= c)
                        ans++;
                }
            }
        }
        return ans;
    }
}