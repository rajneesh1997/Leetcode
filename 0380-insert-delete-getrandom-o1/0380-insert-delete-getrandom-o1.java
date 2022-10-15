class RandomizedSet {
    HashMap<Integer,Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.get(val) != null)
            return false;
        list.add(val);
        map.put(val,list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.get(val) == null)
            return false;
        int indx = map.get(val);
        int lastVal = list.get(list.size()-1);
        list.set(indx,lastVal);
        map.put(lastVal,indx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int siz = list.size();
        return list.get((int)(Math.random() * siz));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */