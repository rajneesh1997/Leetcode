class Solution {
public:
    int count = 0;
    int countOperations(int num1, int num2) {
        if(num1 == 0 || num2 == 0) return count;
        count++;
        if(num1 >= num2)
            countOperations(num1-num2,num2);
        else
            countOperations(num1,num2-num1);
        return count;
    }
};