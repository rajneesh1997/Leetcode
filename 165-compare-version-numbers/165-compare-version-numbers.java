class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i, j;
        for(i = 0, j = 0; i < str1.length && j < str2.length; i++, j++){
            int value = compare(str1[i], str2[j]);
            if(value == 0)
                continue;
            else
                return value;
        }
        while(i < str1.length){
            int value = Integer.parseInt(str1[i++]);
            if(value != 0){
                return 1;
            }
        }
        while(j < str2.length){
            int value = Integer.parseInt(str2[j++]);
            if(value != 0){
                return -1;
            }
        }
        return 0;
    }
    
    public int compare(String str1, String str2){
        int val1 = Integer.parseInt(str1);
        int val2 = Integer.parseInt(str2);
        return val1 < val2 ? -1 : val1 > val2 ? 1 : 0;
    }
}