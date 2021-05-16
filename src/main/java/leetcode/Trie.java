package leetcode;

import java.util.concurrent.ConcurrentHashMap;

class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;

    private final int DICT = 26;

    public TrieNode() {
        children = new TrieNode[DICT];
        isEnd = false;
    }

    public void put(char ch) {
        children[ch - 'a'] = new TrieNode();
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            if (tmp.get(word.charAt(i)) == null) {

                tmp.put(word.charAt(i));

            }
            tmp = tmp.get(word.charAt(i));
        }

        tmp.setIsEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            tmp = tmp.get(word.charAt(i));
            if (tmp == null) {
                return false;
            }
        }

        return tmp.isEnd();

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            tmp = tmp.get(prefix.charAt(i));
            if (tmp == null) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple"); // return True
        trie.search("app"); // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app"); // return True

    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */