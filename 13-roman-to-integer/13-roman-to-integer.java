class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i = 0, ans = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if (c == 'I' && i+1 < s.length() && s.charAt(i+1) == 'V'){
                ans += 4;
                i++;
            } else if (c == 'I' && i+1 < s.length() && s.charAt(i+1) == 'X'){
                ans += 9;
                i++;
            } else if (c == 'X' && i+1 < s.length() && s.charAt(i+1) == 'L'){
                ans += 40;
                i++;
            } else if (c == 'X' && i+1 < s.length() && s.charAt(i+1) == 'C'){
                ans += 90;
                i++;
            } else if (c == 'C' && i+1 < s.length() && s.charAt(i+1) == 'D'){
                ans += 400;
                i++;
            } else if (c == 'C' && i+1 < s.length() && s.charAt(i+1) == 'M'){
                ans += 900;
                i++;
            } else {
                ans += map.get(c);
            }
            i++;
        }
        
        return ans;
    }
}