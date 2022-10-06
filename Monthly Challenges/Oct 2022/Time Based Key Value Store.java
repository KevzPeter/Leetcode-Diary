// Daily challenge : 6/10/22

class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new TreeMap<Integer, String>());
        }
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        Integer timestamp_prev = timeMap.get(key).floorKey(timestamp);
        if(timestamp_prev == null) return  "";
        String val = timeMap.get(key).get(timestamp_prev);
        return val == null ? "" : val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */