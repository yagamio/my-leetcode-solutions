/**
 * 677. Map Sum Pairs
 * Trie. Treat class MapSum as a trie.
 * Time complexity: O()
 * Space complexity: O()
 */
class MapSum {
    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for (char letter : key.toCharArray()) {
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for (char letter : prefix.toCharArray()) {
            if (!node.children.containsKey(letter)) {
                return 0; // if prefix does not exist, return 0
            }
            node = node.children.get(letter); // moving node to the end of prefix
        }
        return sumStartingFromNode(node);
    }

    private int sumStartingFromNode(TrieNode node) {
        int sum = node.val; // first add the value of prefix itself to sum
        for (TrieNode child : node.children.values()) {
            sum += sumStartingFromNode(child);
        }
        return sum;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    int val;
    
    public TrieNode() {
        children = new HashMap<>();
        val = 0;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */