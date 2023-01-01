import java.util.HashSet;
import java.util.Set;

public class PrimeFactors {
    private static Set<Integer> primeFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2)
            factors.add(n);
        return factors;
    }
}
