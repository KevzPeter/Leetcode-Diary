class Solution {
    private static final String[] keyPad = { "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return List.of();
        List<String> res = new ArrayList<String>();
        helper(0, digits, res, new StringBuilder());
        return res;
    }

    private void helper(int i, String digits, List<String> res, StringBuilder curr) {
        if (i == digits.length()) {
            res.add(curr.toString());
            return;
        }
        char digit = digits.charAt(i);
        for (char letter : keyPad[digit - '2'].toCharArray()) {
            curr.append(letter);
            helper(i + 1, digits, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}