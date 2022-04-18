class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        priority_queue <int, vector<int>, greater<int> > pq;
        for(auto x:nums){
            pq.push(x);
        }
        for(int i = 1; i <= k; i++){
            int num = pq.top();
            pq.pop();
            pq.push(num+1);
        }
        long long int mul = 1;
        while(pq.empty() == false){
            mul = mul*pq.top();
            mul = mul % (1000000007);
            pq.pop();
        }
        return mul;
    }
};