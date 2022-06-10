class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        while(columnNumber > 26){
            int rem = columnNumber % 26;
            int qu = columnNumber / 26;
            if(rem == 0){
                ans = "Z" + ans;
                qu--;
            }
            else
                ans = Character.toString((char) 64 + rem) + ans;
            columnNumber = qu;
        }
        if(columnNumber == 0)
            ans = "Z" + ans;
        else
            ans = Character.toString((char) 64 + columnNumber) + ans;
        return ans;
    }
}