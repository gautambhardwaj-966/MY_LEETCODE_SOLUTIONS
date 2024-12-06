class TextEditor {
    private StringBuilder text;
    private int cursor;

    public TextEditor() {
        text = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String textToAdd) {
        text.insert(cursor, textToAdd);
        cursor += textToAdd.length();
    }
    
    public int deleteText(int k) {
        int charsToDelete = Math.min(k, cursor);
        text.delete(cursor - charsToDelete, cursor);
        cursor -= charsToDelete;
        return charsToDelete;
    }
    
    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        return getLast10Chars();
    }
    
    public String cursorRight(int k) {
        cursor = Math.min(text.length(), cursor + k);
        return getLast10Chars();
    }
    
    private String getLast10Chars() {
        int start = Math.max(0, cursor - 10);
        return text.substring(start, cursor);
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
