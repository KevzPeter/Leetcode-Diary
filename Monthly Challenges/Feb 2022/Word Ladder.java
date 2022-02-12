// date : 12-02-2022
// TC : O(n*m^2)
// SC : O(n + nm) --> O(nm)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean endNotFound = true;
        boolean beginNotFound = true;

        for (String word : wordList) {
            if (word.equals(endWord)) {
                endNotFound = false;
                break;
            }
            if (word.equals(beginWord))
                beginNotFound = false;
        }

        if (endNotFound)
            return 0;
        if (beginNotFound)
            wordList.add(beginWord);

        HashMap<String, List<String>> map = new HashMap<>();
        // generate patterns for hashmap
        for (String word : wordList) {
            int len = word.length();
            for (int j = 0; j < len; j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1, len);
                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<String>());
                }
                map.get(pattern).add(word);
            }
        }
        // do BFS
        int res = 1;
        Set<String> set = new HashSet<>();
        set.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(endWord))
                    return res;
                int len = temp.length();
                for (int j = 0; j < len; j++) {
                    String pattern = temp.substring(0, j) + "*" + temp.substring(j + 1, len);
                    for (String nei : map.get(pattern)) {
                        if (!set.contains(nei)) {
                            set.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}