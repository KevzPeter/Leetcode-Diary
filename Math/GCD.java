public class GCD {
    public static void main(String[] args) {
        GCD obj = new GCD();
        int a = 10;
        int b = 36;
        int res = obj.gcd(a, b);
        System.out.println("Greatest common divisor [" + a + "," + b + "]: " + res);
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
