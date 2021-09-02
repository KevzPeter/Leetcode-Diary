class Solution {
    public String reverseWords(String s) {
    String[] strs = s.split(" ");
    StringBuilder result = new StringBuilder();

    for(String str: strs){
        str = new StringBuilder(str).reverse().toString();
        result.append(str + " ");
    }

    return result.toString().trim();
}
}