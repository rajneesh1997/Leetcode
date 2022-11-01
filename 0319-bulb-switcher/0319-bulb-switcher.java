class Solution {
    public int bulbSwitch(int n) {
        int ans = 0;
        int i = 0;
        while((i * i) <= n){
            ans = i++;
        }
        return ans;
    }
}