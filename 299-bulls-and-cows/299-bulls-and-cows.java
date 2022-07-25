class Solution {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        for(char c : secret.toCharArray()){
            arr[c-'0']++;
        }
        String ans = "";
        int bull = 0, cow = 0;
        int n = guess.length();
        int i = 0;
        while(i < n){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a == b){
                bull++;
                arr[a-'0']--;
            } 
            i++;
        }
        i=0;
        while(i < n){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a != b && arr[b-'0'] > 0){
                cow++;
                arr[b-'0']--;
            } 
            i++;
        }
        ans = bull + "A" + cow + "B";
        return ans;
    }
}