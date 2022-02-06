class RandomizedSet {
    Set<Integer> set= new HashSet<>();
    List<Integer> list=new ArrayList<>();
    public RandomizedSet() {}
    
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val); 
        list.add(val); 
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        list.remove(Integer.valueOf(val)); 
        return true;
    }             
    
    public int getRandom() {
        return list.get((int)(Math.random()*list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */