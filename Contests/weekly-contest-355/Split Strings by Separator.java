/**
 * Split string using separators .,|$#@
 */

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        if (words == null || words.size() == 0)
            return res;
        HashMap<Character, String> map = new HashMap<>();
        map.put('.', "\\.");
        map.put(',', "\\,");
        map.put('|', "\\|");
        map.put('$', "\\$");
        map.put('#', "\\#");
        map.put('@', "\\@");
        for (String s : words) {
            String[] splitWords = s.split(map.get(separator));
            for (String splitWord : splitWords) {
                splitWord = splitWord.trim();
                if (splitWord.length() > 0)
                    res.add(splitWord);
            }
        }

        return res;
    }
}
