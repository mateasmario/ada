public class TrieTree {
    private final int R = 256;
    private TrieNode root;

    private class TrieNode {
        private Integer val;
        private final TrieNode[] next = new TrieNode[R]; // may have R children
    }

    /**
     * Initializes an empty trie tree
     */
    public TrieTree() {
        root = null;
    }


    /**
     * Inserts a word into the trie tree - the recursive implementation
     *
     * @param key the word to be inserted
     * @param val the value associated with the word
     */
    public void put(String key, Integer val) {
        if ((key == null) || (val == null)) throw new IllegalArgumentException("key or val argument is null");
        else root = put(root, key, val);
    }

    private TrieNode put(TrieNode x, String key, Integer val) {
        if (x == null) x = new TrieNode();
        if (key.equals("")) {
            x.val = val;
            return x;
        }
        char c = key.charAt(0);
        String restkey = "";
        if (key.length() > 1) restkey = key.substring(1);
        x.next[c] = put(x.next[c], restkey, val);
        return x;
    }

    public static void main(String[] args) {

    }
}

