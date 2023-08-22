class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber >= 1) {
            if (columnNumber % 26 == 0) {
                sb.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            } else {
                sb.append((char) ('A' + columnNumber % 26 - 1));
                columnNumber = columnNumber / 26;
            }
        }
        return sb.reverse().toString();
    }
}