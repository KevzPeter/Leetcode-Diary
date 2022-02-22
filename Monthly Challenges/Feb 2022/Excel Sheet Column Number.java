//22-02-2022
class Solution{
    public int getColumnNumber(String columnTitle){
        int columnNumber = 0;
        int pow = 0;
        int i = columnTitle.length() - 1;
        while(i>=0){
            columnNumber += (int)(columnTitle.charAt(i) - 'A' + 1) * (int)Math.pow(26, pow);
            pow++;
            i--;
        }
        return columnNumber;
    }
}