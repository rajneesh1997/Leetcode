class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size() - 1;
        int width = j;
        int ans = INT_MIN;
        while(i < j){
            int m1 = min(height[i],height[j]);
            ans = max(ans, m1*width--);
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return ans;
    }
};