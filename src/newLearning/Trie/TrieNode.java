package newLearning.Trie;

public class TrieNode {
    public TrieNode[] children;
    public boolean isLeaf;
    public TrieNode(){
        children = new TrieNode[26];
        isLeaf = false;
    }
}
