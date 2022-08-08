class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    boolean impossible = false;
    public void dfs(int course, int[] visited){
        if(visited[course] == 0){
            visited[course] = 1;
            if(map.containsKey(course)){
                for(int i = 0; i < map.get(course).size(); i++){
                    dfs(map.get(course).get(i), visited);
                }
            }
            visited[course] = 2;
            arr.add(course);
        } else {
            if(visited[course] == 1){
                impossible = true;
                return;
            }
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int[] p : prerequisites){
            int a = p[0], b = p[1];
            map.computeIfAbsent(b, k -> new ArrayList());
            map.get(b).add(a);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            dfs(i, visited);
        }
        int[] ans = new int[numCourses];
        if(impossible) return new int[0];
        for(int i = 0; i < arr.size(); i++){
            ans[i] = arr.get(arr.size() -1 -i);
        }
        return ans;
    }
}