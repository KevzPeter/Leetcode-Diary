import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] reports,
            int[] student_id, int k) {
        Set<String> positive = new HashSet<>();
        Set<String> negative = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]));
        for (String word : positive_feedback)
            positive.add(word);
        for (String word : negative_feedback)
            negative.add(word);
        int n = reports.length;
        for (int i = 0; i < n; i++) {
            String[] words = reports[i].split(" ");
            int positives = 0, negatives = 0;
            for (String word : words) {
                if (positive.contains(word))
                    positives++;
                else if (negative.contains(word))
                    negatives++;
            }
            map.put(student_id[i], map.getOrDefault(student_id[i], 0) + (positives * 3 - negatives));
        }
        for (HashMap.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(new int[] { e.getKey(), e.getValue() });
        }
        while (k-- > 0) {
            res.add(pq.poll()[0]);
        }
        return res;
    }
}