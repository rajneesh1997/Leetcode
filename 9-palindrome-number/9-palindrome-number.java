class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x % 10 == 0 && x !=0))
            return false;
        int new_x = 0;
        while(x > new_x){
            new_x = new_x * 10 + (x % 10);
            x /= 10;
        }
        return x == new_x || x == new_x/10;
    }
}