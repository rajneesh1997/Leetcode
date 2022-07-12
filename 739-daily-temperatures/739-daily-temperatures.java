class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(temperatures[j]>temperatures[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}