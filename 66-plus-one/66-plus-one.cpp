class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int size = digits.size() - 1;
        int carry = 0;
        for(int i = size; i>-1; i--){
            if(i == size){
                digits[i]++;
            }
            if(carry){
                digits[i]+=carry;
                carry = 0;
            }
            if(digits[i] > 9){
                carry = digits[i] / 10;
                digits[i] %= 10;
            }
            else{
                break;
            }
        }
        if(carry){
            digits.insert(digits.begin(),carry);
        }
        return digits;
    }
};