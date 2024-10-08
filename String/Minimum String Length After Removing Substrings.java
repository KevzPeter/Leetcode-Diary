class Solution {
    public int minLength(String s) {
        int minLength = s.length();
        while (true) {
            int index1 = s.indexOf("AB");
            int index2 = s.indexOf("CD");
            if (index1 == -1 && index2 == -1) {
                break;
            } else if (index1 != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, index1));
                sb.append(s.substring(index1 + 2));
                s = sb.toString();
                minLength = s.length();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, index2));
                sb.append(s.substring(index2 + 2));
                s = sb.toString();
                minLength = s.length();
            }
        }
        return minLength;
    }
}