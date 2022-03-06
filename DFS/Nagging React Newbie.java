import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int N, M, x, y;
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] vis = new boolean[(int) 1e5];
        N = in.nextInt();
        for (int i = 0; i < N; i++) {
            x = in.nextInt();
            map.putIfAbsent(x, new ArrayList<>());
        }
        M = in.nextInt();
        for (int i = 0; i < M; i++) {
            x = in.nextInt();
            y = in.nextInt();
            map.get(x).add(y);
        }
        x = in.nextInt();
        y = in.nextInt();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        vis[x] = true;
        q.offer(x);
        while (!q.isEmpty()) {
            int z = q.poll();
            for (int i : map.get(z)) {
                if (!vis[i]) {
                    if (i == y) {
                        res.add(z);
                    } else {
                        vis[i] = true;
                        q.offer(i);
                    }
                }
            }
        }
        Collections.sort(res);
        if (res.size() == 0) {
            System.out.println(-1);
            return;
        }
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}