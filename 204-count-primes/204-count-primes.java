class Solution {
    public int countPrimes(int n) {
        if(n == 1 || n == 0) return 0;
        int[] arr = new int[n];
        for(int i = 2; i < n; i++){
            if(arr[i] == 0){
                for(int j = 2 * i; j < n; j+=i)
                    arr[j] = 1;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(arr[i] == 0)
                count++;
        }
        return count;
    }
}