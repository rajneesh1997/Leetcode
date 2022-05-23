class Solution {
    public int mySqrt(int x) {
        int i = 0;
        while(i <= 46340){
            if (x >= (i*i))
                i++;
            else
                break;
        }
        return i-1;
    }
}