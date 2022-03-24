package com.company.algorithms;

import java.util.HashMap;

public class Trie {

    class TrieNode{
        public char c;
        public boolean isWord;
        public HashMap<Character, TrieNode> leafNodes; //字节点

        public TrieNode(char c, boolean isWord){
            this.c = c;
            this.isWord = isWord;
            this.leafNodes = new HashMap<>();
        }
    }

    private TrieNode head;

    public Trie() {
        this.head = new TrieNode('a', false);
    }

    public void insert(String word) {
        int wordLength = word.length();
        char[] chs = word.toCharArray();
        TrieNode currentNode = this.head;
        TrieNode temp;
        for (int i=0; i<wordLength; i++){
            if (currentNode.leafNodes.containsKey(chs[i])){
                if (i == wordLength -1){
                    currentNode.leafNodes.get(chs[i]).isWord = true;
                }
                temp = currentNode.leafNodes.get(chs[i]);
            }else{
                temp = new TrieNode(chs[i], i==wordLength-1);
                currentNode.leafNodes.put(chs[i], temp);
            }
            currentNode = temp;
        }
    }

    public boolean search(String word) {
        int wordLength = word.length();
        char[] chs = word.toCharArray();
        TrieNode current = this.head;
        for (int i=0; i<wordLength; i++){
            if(current.leafNodes.containsKey(chs[i]) && !current.leafNodes.get(chs[i]).isWord){
                current = current.leafNodes.get(chs[i]);
            }else if(current.leafNodes.containsKey(chs[i]) && current.leafNodes.get(chs[i]).isWord){
                if (i == wordLength-1){
                    return true;
                }else {
                    current = current.leafNodes.get(chs[i]);
                }
            }else {
                return false;
            }
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        int wordLength = prefix.length();
        char[] chs = prefix.toCharArray();
        TrieNode current = this.head;
        for (int i=0; i<wordLength; i++){
            if(current.leafNodes.containsKey(chs[i])){
                current = current.leafNodes.get(chs[i]);
            }else{
                return false;
            }
        }

        return true;
    }
}