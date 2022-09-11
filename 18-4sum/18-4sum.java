class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            long sumA = nums[i];
            
            for(int j = i+1; j < n; j++){
                if(j != i+1 && nums[j] == nums[j-1])
                    continue;
                temp.add(nums[j]);
                long sumB = nums[j];
                
                for(int k = j+1; k < n; k++){
                    if(k != j+1 && nums[k] == nums[k-1])
                        continue;
                    temp.add(nums[k]);
                    long sumC = nums[k];
                    
                    for(int l = k+1; l < n; l++){
                        if(l != k+1 && nums[l] == nums[l-1])
                            continue;
                        if((sumA + sumB + sumC + (long)nums[l]) == (long)target){
                            temp.add(nums[l]);
                            ans.add(new ArrayList<>(temp));
                            temp.remove(temp.size()-1);
                        }
                    }
                    
                    temp.remove(temp.size()-1);
                }
                temp.remove(temp.size()-1);
            }
            temp.remove(temp.size()-1);
        }
        return ans;
    }
}