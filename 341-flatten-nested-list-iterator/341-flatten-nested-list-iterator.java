/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> ans = new ArrayList();
    int cnt = 0;
    
    public void makeList(List<NestedInteger> nestedList, int size){
        int i = 0;
        while(i < size){
            if(nestedList.get(i).isInteger()){
                ans.add(nestedList.get(i).getInteger());
            } else {
                List<NestedInteger> lt = nestedList.get(i).getList();
                makeList(lt,lt.size());
            }
            i++;
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        int size = nestedList.size();
        makeList(nestedList,size);
    }

    @Override
    public Integer next() {
        ++cnt;
        return ans.get(cnt-1);
    }

    @Override
    public boolean hasNext() {
        if(cnt >= ans.size())
            return false;
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */