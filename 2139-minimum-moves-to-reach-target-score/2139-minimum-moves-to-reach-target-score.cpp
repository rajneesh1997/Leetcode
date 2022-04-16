class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        if(target == 1) return 0;
        if(maxDoubles == 0){
            return target-1;
        }
        int ans = 0;
        while(target != 1 and maxDoubles > 0){
            if(target % 2 == 0){
                target = target / 2;
                ans++;
                maxDoubles--;
            }else{
                ans++;
                target--;
            }
        }
        return ans + target-1;
    }
};