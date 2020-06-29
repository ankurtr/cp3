package com.ds;

class TrieNode {
    int maxChars = 26;
    TrieNode[] links;
    String text = "";

    public TrieNode() {
        links = new TrieNode[maxChars];
    }

    public void add(char c, TrieNode node) {
        if (links[c - 'a'] == null) {
            links[c - 'a'] = node;
        }
    }

    public TrieNode getChild(char c) {
        return links[c - 'a'];
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class TrieImpl {
    private static TrieNode root = new TrieNode();

    public static void insert(String text) {
        TrieNode current = root;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (current.getChild(symbol) == null) {
                current.add(symbol, new TrieNode());
                current = current.getChild(symbol);
            }
        }
        current.setText(text);
    }

    public static boolean search(String text) {
        TrieNode current = root;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (current.getChild(symbol) != null) {
                current = current.getChild(symbol);
            } else {
                return false;
            }
        }
        return current.getText().equals(text);
    }

    public static boolean startsWith(String text) {
        TrieNode current = root;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (current.getChild(symbol) == null) {
                return false;
            }
            current = current.getChild(symbol);
        }
        return true;
    }

    public static void main(String[] args) {
        insert("apple");
        System.out.println(search("apple"));
        System.out.println(search("app"));
        System.out.println(startsWith("app"));
    }
}