class Solution {
    private static boolean[] notPrime;
    public int minSteps(int n) {
        if(n == 1) return 0;
        if(notPrime == null){
            generatePrimes();
        }
        if(!notPrime[n]) return n;
        int steps = 0;
        while(n % 2 == 0){
            steps += 2;
            n /= 2;
        }
        for(int i = 3; i * i <= n; i += 2){
            while(n % i == 0){
                steps += i;
                n /= i;
            }
        }
        if(n > 2) steps += n;
        return steps;
    }
    private void generatePrimes(){
        notPrime = new boolean[1001];
        for(int i = 2; i * i <= 1000; i++){
            if(!notPrime[i]){
                for(int p = i * i; p <= 1000; p += i){
                    notPrime[p] = true;
                }
            }
        }
    }
}