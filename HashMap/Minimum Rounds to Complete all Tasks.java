class Solution {
    public int minimumRounds(int[] tasks) {
        int rounds = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int freq = e.getValue();
            if(freq <= 1) return -1;
            rounds += freq % 3 == 0 ? freq / 3 : freq / 3 + 1;
        }
        return rounds;
    }
}