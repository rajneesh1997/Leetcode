class Solution {
    public ArrayList<Integer> addStrings(ArrayList<Integer> num1, ArrayList<Integer> num2){
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;
        
        for(int i = 0; i < num1.size() || i < num2.size(); i++){
            int a = i < num1.size() ? num1.get(i) : 0;
            int b = i < num2.size() ? num2.get(i) : 0;
            int s = a + b + carry;
            carry = s / 10;
            ans.add(s  % 10);
        }
        
        if(carry != 0)
            ans.add(carry);
        
        return ans;
    }
    
    public ArrayList<Integer> multiplyOneDigit(StringBuilder first, char secondDigit, int numZeros){
        ArrayList<Integer> currentResult = new ArrayList<>();
        for (int i = 0; i < numZeros; ++i) {
            currentResult.add(0);
        }
        
        int carry = 0;
        
        for(int i = 0; i < first.length(); i++){
            int mul = ((first.charAt(i) -'0') * (secondDigit - '0')) + carry;
            carry = mul / 10;
            currentResult.add(mul % 10);
        }
        
        if(carry != 0){
            currentResult.add(carry);
        }
        
        return currentResult;
    }
    
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        StringBuilder first = new StringBuilder(num1);
        StringBuilder second = new StringBuilder(num2);
        
        first.reverse();
        second.reverse();
        
        int n = first.length() + second.length();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ans.add(0);
        }
        
        for(int i = 0; i < second.length(); i++){
            ans = addStrings(multiplyOneDigit(first,second.charAt(i),i),ans);
        }
        
        if (ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = ans.size() - 1; i >= 0; --i) {
            answer.append(ans.get(i));
        }
        
        return answer.toString();
        
    }
}