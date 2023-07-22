class Solution {
    String vowels = "aeiouAEIOU";

    public String sortVowels(String s) {
        List<Integer> vowelIndices = new ArrayList<>();
        List<Character> vowelsList = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                vowelsList.add(s.charAt(i));
                vowelIndices.add(i);
            }
        }
        Collections.sort(vowelsList, (a, b) -> ((int) a - (int) b));
        int vowelIdx = 0;
        char[] t = new char[len];
        for (int i = 0; i < len; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                t[i] = vowelsList.get(vowelIdx++);
            } else {
                t[i] = s.charAt(i);
            }
        }
        return new String(t);
    }
}