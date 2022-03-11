class Solution {
public:
    vector<string> ans;
    void generate(int open, int close, int n, string str){
        if(open < close) return;
        if(open > n || close > n) return;
        if(open == n and close == n){
            ans.push_back(str);
            return;
        }
        generate(open + 1, close, n, str + "(");
        generate(open, close + 1, n, str + ")");
    }
    vector<string> generateParenthesis(int n) {
        generate(0,0,n,"");
        return ans;
    }
};