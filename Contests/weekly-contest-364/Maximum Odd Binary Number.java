class Solution {
    public String maximumOddBinaryNumber(String s) {
        int len = s.length(), numberOfOnes = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                numberOfOnes++;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            if (i < numberOfOnes - 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        sb.append("1");
        return sb.toString();

    }
}