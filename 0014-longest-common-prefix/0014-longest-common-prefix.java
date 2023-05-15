class Solution {
    /**
     * 14. Longest Common Prefix
     * Trie.
     * n is the size of strs. m is the length of word in strs. p is the length of prefix.
     * Time complexity: O(m * n + p).
     * Space complexity: O(m * n + p).
     */
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String word : strs) {
            if (word.equals("")) return "";  // 如果单词是空字符串，公共前缀也为空字符串
            trie.insert(word);
        }
        TrieNode node = trie.getRoot(); // 用getRoot方法来获取root
        StringBuilder sb = new StringBuilder();
        
        // 当子节点长度为1且不是单词末尾时，才进入循环。如果是末尾就不符合前缀定义了
        while (node.children.size() == 1 && !node.endOfWord) {
            Set<Character> keys = node.children.keySet();
            char key = '\0'; // '\0'代表空字符
            for (char c : keys) {
                key = c;
                sb.append(key);
                break;
            }
            node = node.children.get(key);
        }
        return sb.toString();
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private class Trie {
        TrieNode root;

        public TrieNode getRoot() {
            return root;
        }

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)){
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c); // 将当前指针转到孩子节点（不是孩子的孩子）
            }
            node.endOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return node.endOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return true;
        }

    }

}