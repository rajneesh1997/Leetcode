class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
        int maxFreq = s.length();
        int del = 0;
        for(int i = 25; i > -1 && arr[i] > 0; i--){
            if(arr[i] > maxFreq){
                del += arr[i]-maxFreq;
                arr[i] = maxFreq;
            }
            maxFreq = Math.max(0,arr[i]-1);
        }
        return del;
    }
}