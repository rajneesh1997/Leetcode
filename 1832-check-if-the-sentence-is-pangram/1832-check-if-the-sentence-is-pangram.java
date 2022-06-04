class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 0)
            return false;
        for(char i = 'a'; i <= 'z'; i++){
            if(sentence.indexOf(i)<0)
                return false;
        }
        return true;
    }
}