class Solution {
public:
    int calPoints(vector<string>& ops) {
        stack<int> st;
        for(auto ch:ops){
            if(ch != "C" and ch != "D" and ch != "+"){
                int n = stoi(ch);
                st.push(n);
            }else{
                if(ch == "C") st.pop();
                else if(ch == "D") st.push(st.top() * 2);
                else if(ch == "+"){
                    int n = st.top();
                    st.pop();
                    int nv = n + st.top();
                    st.push(n);
                    st.push(nv);
                }
            }
        }
        int ans = 0;
        while(st.size() > 0){
            ans += st.top();
            st.pop();
        }
        return ans;
    }
};