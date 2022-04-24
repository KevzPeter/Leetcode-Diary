class UndergroundSystem {
    class CheckInDetails {
        private String station;
        private int time;

        public CheckInDetails(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class TimeDetails {
        private int count;
        private int totalTime;

        public TimeDetails(int count, int totalTime) {
            this.count = count;
            this.totalTime = totalTime;
        }
    }

    HashMap<Integer, CheckInDetails> checkInMap;
    HashMap<String, HashMap<String, TimeDetails>> avgTimeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<Integer, CheckInDetails>();
        avgTimeMap = new HashMap<String, HashMap<String, TimeDetails>>();
    }

    public void checkIn(int id, String stationName, int t) {
        CheckInDetails check = new CheckInDetails(stationName, t);
        checkInMap.put(id, check);
    }

    public void checkOut(int id, String stationName, int checkOutTime) {
        CheckInDetails check = checkInMap.get(id);
        int checkInTime = check.time;
        String checkInStation = check.station;
        checkInMap.remove(id);
        int duration = checkOutTime - checkInTime;
        HashMap timeMap = avgTimeMap.get(checkInStation);
        if (timeMap == null) {
            timeMap = new HashMap<String, TimeDetails>();
            avgTimeMap.put(checkInStation, timeMap);
        }
        if (timeMap.get(stationName) == null) {
            TimeDetails time = new TimeDetails(1, duration);
            timeMap.put(stationName, time);
        } else {
            TimeDetails oldTimeDetails = (TimeDetails) timeMap.get(stationName);
            int oldCount = oldTimeDetails.count;
            int oldTotal = oldTimeDetails.totalTime;
            TimeDetails time = new TimeDetails(oldCount + 1, oldTotal + duration);
            timeMap.put(stationName, time);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        TimeDetails detail = avgTimeMap.get(startStation).get(endStation);
        return (double) detail.totalTime / (double) detail.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
