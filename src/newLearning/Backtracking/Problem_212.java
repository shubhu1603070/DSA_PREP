package newLearning.Backtracking;

import newLearning.Trie.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class Problem_212 {

    TrieNode root;


    public static void main(String[] args) {

    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> list = new ArrayList<>();

        for(String word : words){
            insert(word);
        }

        for(int row = 0;row <= board.length;row++){
            for(int col = 0;col <= board[0].length;col++){
                TrieNode node = root;
                dfs(node,board,list,"",row,col);
            }
        }

        return list;
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

    private void dfs(TrieNode node, char[][] words, List<String> list,String word,int row,int col){
        if(row >= words.length || row < 0 || col >= words.length || col < 0 || node == null) return;
        if(node.isLeaf) list.add(word);
        char temp = words[row][col];
        words[row][col] = '#';
        node = node.children[temp-'a'];
        dfs(node,words,list,word+temp,row+1,col);
        dfs(node,words,list,word+temp,row-1,col);
        dfs(node,words,list,word+temp,row,col+1);
        dfs(node,words,list,word+temp,row,col-1);
        words[row][col] = temp;
    }




}
