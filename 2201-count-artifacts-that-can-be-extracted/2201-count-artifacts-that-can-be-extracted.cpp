class Solution {
public:
    int digArtifacts(int n, vector<vector<int>>& artifacts, vector<vector<int>>& dig) {
        vector<vector<bool>> v(n,vector(n,false));
        for(auto x:dig){
            v[x[0]][x[1]] = true;
        }
        int ans = 0;
        for(auto x:artifacts){
            bool flag = true;
            int r1 = x[0];
            int c1 = x[1];
            int r2 = x[2];
            int c2 = x[3];
            for(int i = r1; i <= r2; i++)
                for(int j = c1; j <= c2 ; j++)
                    if(!v[i][j]){
                        flag = false;
                        break;
                    }
            if(flag)
                ans++;
        }
        return ans;
    }
};