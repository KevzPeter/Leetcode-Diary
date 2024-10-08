class Solution {

    public boolean areSentencesSimilar(String s1, String s2) {
        // Split the words in sentences and store it in a string array.
        String[] s1Words = s1.split(" "), s2Words = s2.split(" ");
        int start = 0, ends1 = s1Words.length - 1, ends2 = s2Words.length - 1, s1WordsLength = s1Words.length,
                s2WordsLength = s2Words.length;

        // If words in s1 are more than s2, swap them and return the answer.
        if (s1WordsLength > s2WordsLength) {
            return areSentencesSimilar(s2, s1);
        }

        // Find the maximum words matching from the beginning.
        while (start < s1WordsLength && s1Words[start].equals(s2Words[start])) {
            ++start;
        }
        // Find the maximum words matching in the end.
        while (ends1 >= 0 && s1Words[ends1].equals(s2Words[ends2])) {
            --ends1;
            --ends2;
        }

        // If i reaches the end of the array, then we return true.
        return ends1 < start;
    }
}