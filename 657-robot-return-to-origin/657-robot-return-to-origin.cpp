class Solution {
public:
    bool judgeCircle(string moves) {
        vector<int> ans(2);
        for(char ch:moves){
            if(ch == 'L'){
                --ans[0];
            }else{
                if(ch == 'R'){
                    ++ans[0];
                }else{
                    if(ch == 'U'){
                        ++ans[1];
                    }else{
                        --ans[1];
                    }
                }
            }
        }
        return (ans[0] == 0) & (ans[1] == 0);
    }
};