class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        // System.out.println(intervals[0][0] + " " + intervals[0][1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = intervals.length;
        for(int i = 0; i < n; i++){
            if(minHeap.size() > 0 && minHeap.peek() <= intervals[i][0]){
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}