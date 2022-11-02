class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] ch = new int[26];
        int[] ch2 = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            ch[c-'a'] = i+1;
        }
        for(int i = n-1; i > -1; i--){
            char c = s.charAt(i);
            ch2[c-'a'] = i;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(26,(a,b)->a[0]-b[0]);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            // if(ch[i] == 0 && ch2[i] == 0)
            //     continue;
            queue.add(new int[]{ch2[i], ch[i]});
            // System.out.println('a'+i + " " + ch2[i] + " " + ch[i]);
        }
        int tmp = 0, first = Integer.MAX_VALUE, second = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            if(arr[0] == second){
                if(second - first > 0)
                    ans.add(second-first);
                first = arr[0];
                second = arr[1];
            }
            first = Math.min(first,arr[0]);
            second = Math.max(second,arr[1]);
            // System.out.println(arr[0] + " " + arr[1]);
        }
        // for(int i = 0; i < 26; i++){
        //     if(ch[i] == 0 && ch2[i] == 0)
        //         continue;
        //     if(ch2[i] == second){
        //         ans.add(second-first);
        //         first = ch2[i];
        //         second = ch[i];
        //     }
        //     first = Math.min(first,ch2[i]);
        //     second = Math.max(second,ch[i]);
        // }
        ans.add(second-first);
        return ans;
    }
}