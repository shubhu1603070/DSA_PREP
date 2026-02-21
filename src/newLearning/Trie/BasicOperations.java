package newLearning.Trie;

public class BasicOperations {

    TrieNode root;

    BasicOperations(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isLeaf = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return node.isLeaf;
    }

    public boolean isPrefix(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return true;
    }

    public boolean isEmpty(TrieNode node){
        for(TrieNode child:node.children){
            if(child != null) return false;
        }
        return true;
    }

    public TrieNode delete(TrieNode node,int index,String word){
        if(node == null) return null;
        if(index == word.length()){
            if(node.isLeaf) node.isLeaf = false;
            if(isEmpty(node)){
                node = null;
            }
            return node;
        }
        int tempIndex = word.charAt(index) - 'a';
        node.children[tempIndex] = delete(node.children[tempIndex],index+1,word);
        if(isEmpty(node) && !node.isLeaf){
            node = null;
        }
        return node;
    }

    public static void main(String[] args) {
        BasicOperations b = new BasicOperations();
        String[] str = {"and", "ant", "do", "dad"};
        for(String word:str){
            b.insert(word);
        }
        System.out.println(b.search("and"));
        System.out.println(b.isPrefix("an"));
        b.delete(b.root,0,"dad");
        System.out.println(b.isPrefix("dad"));
    }


}
