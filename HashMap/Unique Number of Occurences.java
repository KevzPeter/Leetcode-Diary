class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        Arrays.stream(arr).forEach(i -> freqMap.put(i, freqMap.getOrDefault(i, 0) + 1));

        Set<Integer> freqs = new HashSet<>(freqMap.values());

        return freqs.size() == freqMap.size();
    }
}