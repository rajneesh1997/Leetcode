class Solution {
    public int sum(int n){
        int s = 0;
        while(n != 0){
            s += (n % 10) * (n % 10);
            n /= 10;
        }
        return s;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer> ();
        while(!set.contains(n)){
            set.add(n);
            if( n==1 ) return true;
            n = sum(n);
        }
        return false;
    }
}