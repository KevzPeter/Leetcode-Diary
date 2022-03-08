import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long x = 0;
        List<Long> list = new ArrayList<>();
        while (n-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            x -= a;
            list.add((long) (a + a + b));
        }
        Collections.sort(list, Collections.reverseOrder());
        long count = 0;
        for (long i : list) {
            x += i;
            count++;
            if (x > 0)
                break;
        }
        System.out.println(count);
    }
}
