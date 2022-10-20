class WordMap {
    String word;
    int count;

    WordMap(String w, int c) {
        word = w;
        count = c;
    }
}

class CustomComparator implements Comparator<WordMap> {
    @Override
    public int compare(WordMap wm1, WordMap wm2) {
        return wm1.count == wm2.count ? wm2.word.compareTo(wm1.word) : wm1.count - wm2.count;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<WordMap> pq = new PriorityQueue<>(new CustomComparator());
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.offer(new WordMap(e.getKey(), e.getValue()));
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty() && res.size() < k) {
            res.addFirst(pq.poll().word);
        }
        return res;
    }
}