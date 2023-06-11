class SnapshotArray {
    List<TreeMap<Integer, Integer>> snapshots;
    int snapID;
    public SnapshotArray(int length) {
        snapshots = new ArrayList<>();
        for(int i = 0; i < length; i++){
            snapshots.add(new TreeMap<>());
        }
        snapID = 0;
    }
    
    public void set(int index, int val) {
        snapshots.get(index).put(snapID, val);
    }
    
    public int snap() {
        return ++snapID - 1;
    }
    
    public int get(int index, int snapID) {
        if(snapshots.get(index).get(snapID) == null){
            Integer prevSnap = snapshots.get(index).floorKey(snapID);
            if(prevSnap != null){
                int prevSnapVal = snapshots.get(index).get(prevSnap);
                snapshots.get(index).put(snapID, prevSnapVal);
                return prevSnapVal;
            }
            else{
                return 0;
            }
        }
        return snapshots.get(index).get(snapID);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */