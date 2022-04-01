class Solution {
public:
    void reverseString(vector<char>& s) {
        char ch;
        int j = s.size() - 1;
        int i = 0;
        while(i<=j){
            ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++; j--;
        }
    }
};