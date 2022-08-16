class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
        }
        int f_max = 0 ;
        for(int i : freq){
            f_max = Math.max(f_max,i);
        }
        int n_max = 0;
        for(int f : freq){
            if(f == f_max) n_max++;
        }
        return Math.max(tasks.length, (f_max - 1) * (n + 1) + n_max);
    }
}