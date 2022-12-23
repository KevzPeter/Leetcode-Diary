
// ref : https://www.geeksforgeeks.org/sieve-of-eratosthenes/
import java.util.Vector;

class SieveOfEratosthenes {
    void sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and
        // initialize all entries it as true. A value in
        // prime[i] will finally be false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p greater than or
                // equal to the square of it numbers which
                // are multiple of p and are less than p^2
                // are already been marked.
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }

    // Driver Code
    public static void main(String args[]) {
        int n = 30;
        System.out.print("Following are the prime numbers ");
        System.out.println("smaller than or equal to " + n);
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(n);
    }
}

// O(n)

class Test {
    static final int MAX_SIZE = 1000001;
    // isPrime[] : isPrime[i] is true if number is prime
    // prime[] : stores all prime number less than N
    // SPF[] that store smallest prime factor of number
    // [for Exp : smallest prime factor of '8' and '16'
    // is '2' so we put SPF[8] = 2 , SPF[16] = 2 ]
    static Vector<Boolean> isprime = new Vector<>(MAX_SIZE);
    static Vector<Integer> prime = new Vector<>();
    static Vector<Integer> SPF = new Vector<>(MAX_SIZE);

    // method generate all prime number less than N in O(n)
    static void manipulated_seive(int N) {
        // 0 and 1 are not prime
        isprime.set(0, false);
        isprime.set(1, false);

        // Fill rest of the entries
        for (int i = 2; i < N; i++) {
            // If isPrime[i] == True then i is
            // prime number
            if (isprime.get(i)) {
                // put i into prime[] vector
                prime.add(i);

                // A prime number is its own smallest
                // prime factor
                SPF.set(i, i);
            }

            // Remove all multiples of i*prime[j] which are
            // not prime by making isPrime[i*prime[j]] = false
            // and put smallest prime factor of i*Prime[j] as prime[j]
            // [for exp :let i = 5, j = 0, prime[j] = 2 [ i*prime[j] = 10]
            // so smallest prime factor of '10' is '2' that is prime[j] ]
            // this loop run only one time for number which are not prime
            for (int j = 0; j < prime.size() &&
                    i * prime.get(j) < N && prime.get(j) <= SPF.get(i); j++) {
                isprime.set(i * prime.get(j), false);

                // put smallest prime factor of i*prime[j]
                SPF.set(i * prime.get(j), prime.get(j));
            }
        }
    }

    // Driver method
    public static void main(String args[]) {
        int N = 13; // Must be less than MAX_SIZE

        // initializing isprime and spf
        for (int i = 0; i < MAX_SIZE; i++) {
            isprime.add(true);
            SPF.add(2);
        }

        manipulated_seive(N);

        // print all prime number less than N
        for (int i = 0; i < prime.size() && prime.get(i) <= N; i++)
            System.out.print(prime.get(i) + " ");
    }
}
