class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if(n % 2 == 1){
            int start = (n/2) * -1;
            int i = 0;
            while(i < n){
                ans[i] = start;
                start++;
                i++;
            }
        } else {
            int start = (n/2) * -1;
            int i = 0;
            while(i < n){
                if(start != 0){
                    ans[i] = start;
                    i++;
                }
                start++;
            }
        }
        return ans;
    }
}