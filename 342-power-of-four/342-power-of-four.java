class Solution {
    public boolean isPowerOfFour(int n) {
        if(n > 4 && n % 4 != 0) return false;
        if(n < 4){
            if(n == 1) 
                return true;
            else
                return false;
        }
        return isPowerOfFour(n / 4);
    }
}