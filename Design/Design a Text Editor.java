// Possibly an O(n^2) soln, as string builder 'insert' and 'delete' are O(n) operations.
// Could use stacks or deque or DLL to solve this as well
class TextEditor {
    StringBuilder textObj;
    int cursorIdx;

    public TextEditor() {
        textObj = new StringBuilder("|");
        cursorIdx = 0;
    }

    public void addText(String text) {
        int len = text.length();
        textObj.insert(cursorIdx, text);
        cursorIdx += len;
    }

    public int deleteText(int k) {
        if (cursorIdx == 0)
            return 0;
        int start = Math.max(0, cursorIdx - k);
        int end = Math.max(0, cursorIdx);
        textObj.delete(start, end);
        cursorIdx -= (end - start);
        return end - start;
    }

    public String cursorLeft(int k) {
        cursorIdx = Math.max(cursorIdx - k, 0);
        int leftIdx = Math.max(cursorIdx - 10, 0);
        return (textObj.substring(leftIdx, cursorIdx)).toString();
    }

    public String cursorRight(int k) {
        cursorIdx = Math.min(cursorIdx + k, textObj.length() - 1);
        int leftIdx = Math.max(cursorIdx - 10, 0);
        return (textObj.substring(leftIdx, cursorIdx)).toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */