class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] i : intervals){
            list.add(i);
        }
        list.add(newInterval);
        Collections.sort(list, (a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> llist = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            if(llist.size() == 0 || llist.getLast()[1] < list.get(i)[0])
                llist.add(list.get(i));
            else
                llist.getLast()[1] = Math.max(llist.getLast()[1], list.get(i)[1]);
        }
        return llist.toArray(new int[llist.size()][]);
    }
}