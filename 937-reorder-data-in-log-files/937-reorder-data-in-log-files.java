class Solution {
    public String[] reorderLogFiles(String[] logs) {
        mergesort(logs,0,logs.length-1);
        return logs;
    }
    
    public void mergesort(String[] logs, int left, int right){
        if(left < right){
            int mid = left + ((right - left) / 2);
            mergesort(logs,left,mid);
            mergesort(logs,mid+1,right);
            merge(logs, left, mid, right);
        }
    }
    
    public void merge(String[] logs, int left, int mid, int right){
        String[] arr = new String[right-left+1];
        int count = 0;
        int lcount = left;
        int rcount = mid+1;
        while(lcount <= mid && rcount <= right){
            if(compare(logs[lcount],logs[rcount])){
                arr[count++] = logs[lcount++];
            } else {
                arr[count++] = logs[rcount++];
            }
        }
        while(lcount <= mid){
            arr[count++] = logs[lcount++];
        }
        while(rcount <= right){
            arr[count++] = logs[rcount++];
        }
        for(int i = 0; i < right-left+1; i++){
            logs[left+i] = arr[i];
        }
    }
    
    public boolean compare(String a, String b){
        String[] logA = fetch(a);
        String[] logB = fetch(b);
        int val = sortIt(logA[1], logB[1]);
        if(val != -1)
            return val == 1 ? true : false;
        val = sortIt(logA[0], logB[0]);
        return val == 1 ? true : false;
    }
    
    public String[] fetch(String a){
        String str = "";
        int i;
        for(i = 0 ; i < a.length(); i++){
            if(a.charAt(i) == ' '){
                break;
            }
            str = str + a.charAt(i);
        }
        String str2 = a.substring(i);
        return new String[]{str, str2};
    }
    
    public int sortIt(String a, String b){
        int i , j;
        for(i = 0, j = 0; i < a.length() && j < b.length(); i++, j++ ){
            char ac = a.charAt(i);
            char bc = b.charAt(j);
            if(ac >= '0' && ac <= '9' && bc >= 'a' && bc <= 'z')
                return 0;
            if(bc >= '0' && bc <= '9' && ac >= 'a' && ac <= 'z')
                return 1;
            if(ac >= '0' && ac <= '9' && bc >= '0' && bc <= '9')
                return 1;
            if(a.charAt(i) != b.charAt(j)){
                if(a.charAt(i) < b.charAt(j))
                    return 1;
                else
                    return 0;
            }
        }
        if(i == a.length()  && j != b.length()) return 1;
        if(j == b.length() && i != a.length()) return 0;
        return -1;
    }
}