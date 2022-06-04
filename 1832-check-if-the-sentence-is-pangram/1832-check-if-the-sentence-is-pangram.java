class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] ans = new int[26];
        for(int i = 0; i < sentence.length(); i++){
            int j = sentence.charAt(i) - 97;
            ans[j]++;
        }
        for(int val : ans)
            if(val == 0)
                return false;
        return true;
    }
}