class Solution {
    public String addBinary(String a, String b) {
        StringBuilder first = new StringBuilder(a);
        StringBuilder second = new StringBuilder(b);
        
        first.reverse();
        second.reverse();
        
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;
        for(int i = 0; i < first.length() || i < second.length(); i++){
            char aa = i < first.length() ? first.charAt(i) : '0';
            char ab = i < second.length() ? second.charAt(i) : '0';
            
            int sum = (aa-'0') + (ab-'0') + carry;
            switch(sum){
                case 0:
                    ans.add(0);
                    carry = 0;
                    break;
                case 1:
                    ans.add(1);
                    carry = 0;
                    break;
                case 2:
                    ans.add(0);
                    carry = 1;
                    break;
                case 3:
                    ans.add(1);
                    carry = 1;
                    break;
                default:
                    break;
            }            
        }
        
        if(carry != 0)
            ans.add(carry);
        
        StringBuilder answer = new StringBuilder();
        for(int i = ans.size()-1 ; i >= 0; i--){
            answer.append(ans.get(i));
        }
        
        return answer.toString();
    }
}