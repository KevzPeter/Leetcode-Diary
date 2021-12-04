import java.util.*;

class TrieNode {
    public boolean isWord;
    public TrieNode words[] = new TrieNode[256];
}

public class ImplementTrie {
    public TrieNode root = new TrieNode();

    public void insert(String word) {
        if (word.length() == 0 || word == null)
            return;
        TrieNode w = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (w.words[c] == null) {
                w.words[c] = new TrieNode();
            }
            w = w.words[c];
        }
        w.isWord = true;
    }

    public boolean search(String word) {
        if (word.length() == 0 || word == null)
            return false;
        TrieNode w = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (w.words[c] == null)
                return false;
            w = w.words[c];
        }
        return w.isWord;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String words[] = new String[] { "kevin", "peter", "kuriakose", "Kevin" };
        ImplementTrie obj = new ImplementTrie();
        for (String word : words) {
            obj.insert(word);
        }
        System.out.println("Enter a word to be search: ");
        String searchword = in.nextLine();
        if (obj.search(searchword))
            System.out.println("The word exists");
        else
            System.out.println("Doesnt exist");
    }
}