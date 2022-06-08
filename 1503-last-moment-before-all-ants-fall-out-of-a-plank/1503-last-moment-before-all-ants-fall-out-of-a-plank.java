class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for(int ant : left)
            ans = Math.max(ant,ans);
        for(int ant : right)
            ans = Math.max(ans,n-ant);
        return ans;
    }
}