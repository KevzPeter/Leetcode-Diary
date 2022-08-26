class Solution {
    public boolean reorderedPowerOf2(int n) {
        int k = 0;
        int[] nFreq = countFreq(n);
        while (k < 31) {
            int num = 1 << k++;
            int[] powFreq = countFreq(num);
            boolean flag = true;
            for (int i = 0; i <= 9; i++) {
                if (nFreq[i] != powFreq[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
        }
        return false;
    }

    private int[] countFreq(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        return freq;
    }
}
// class Solution {
// public boolean reorderedPowerOf2(int n) {
// HashMap<Integer, List<Integer>> map = new HashMap<>();
// int i = 2, pow = 0;
// while (Math.pow(i, pow) < Integer.MAX_VALUE) {
// int num = (int) Math.pow(i, pow);
// int digs = countDigs(num);
// if (!map.containsKey(digs)) {
// map.put(digs, new ArrayList<>());
// }
// map.get(digs).add(num);
// pow++;
// }
// int nDigs = countDigs(n);
// if (!map.containsKey(nDigs))
// return false;
// int[] nFreq = countFreq(n);
// for (int k = 0; k < map.get(nDigs).size(); k++) {
// int[] mapFreq = countFreq(map.get(nDigs).get(k));
// boolean flag = true;
// for (i = 0; i <= 9; i++) {
// if (nFreq[i] != mapFreq[i]) {
// flag = false;
// break;
// }
// }
// if (flag)
// return true;
// }
// return false;
// }

// private int countDigs(int num) {
// int count = 0;
// while (num > 0) {
// count++;
// num /= 10;
// }
// return count;
// }

// private int[] countFreq(int num) {
// int[] freq = new int[10];
// while (num > 0) {
// freq[num % 10]++;
// num /= 10;
// }
// return freq;
// }
// }