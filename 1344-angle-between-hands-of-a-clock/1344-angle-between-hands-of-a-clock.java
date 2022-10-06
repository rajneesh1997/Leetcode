class Solution {
    public double angleClock(int hour, int minutes) {
        double ans = 0;
        if(hour == 12){
            hour = 0;
        }
        double hrHand = ((double)minutes/60) * 30 + (hour * 30);
        double minHand = ((double)minutes/60) * 360;
        ans = Math.abs(minHand - hrHand);
        return Math.abs(Math.min(ans, 360-ans));
    }
}