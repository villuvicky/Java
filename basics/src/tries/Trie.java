package tries;

import java.util.ArrayList;


class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    // Insert using index (optimized, no substring)
    private void insert(TrieNode root, String word, int start) {
        if (start == word.length()) {
            root.isTerminating = true;
            return;
        }

        int childIndex = word.charAt(start) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            child = new TrieNode(word.charAt(start));
            root.children[childIndex] = child;
            root.childCount++;
        }

        insert(child, word, start + 1);
    }

    // Search pattern in Trie
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode root, String word, int start) {
        if (start == word.length()) {
            return true;  // pattern found
        }

        int childIndex = word.charAt(start) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        return search(child, word, start + 1);
    }

    // Main function: pattern matching
    public boolean patternMatching(ArrayList<String> vect, String pattern) {

        // Step 1: Insert all suffixes of all words
        for (String word : vect) {
            for (int i = 0; i < word.length(); i++) {
                insert(root, word, i);
            }
        }

        // Step 2: Search the pattern
        return search(pattern);
    }
    
    public boolean isPalindromePair(ArrayList<String> words) {

        // Step 1: Insert all reversed words into Trie
        for(String word : words) {
            add(reverse(word));
        }

        // Step 2: Check each word
        for(String word : words) {

            // Case 1: word itself is palindrome
            if(isPalindrome(word)) return true;

            // Try all splits
            for(int i = 0; i <= word.length(); i++) {

                String left = word.substring(0, i);
                String right = word.substring(i);

                // Case 2: left exists + right palindrome
                if(search(left) && isPalindrome(right)) {
                    return true;
                }

                // Case 3: right exists + left palindrome
                if(search(right) && isPalindrome(left)) {
                    return true;
                }
            }
        }

        return false;
    }
    

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }        

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if(child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

    public void add(String word){
        add(root, word);
    }
    
    private void printAllWords(TrieNode root, String prefix) {
        if(root == null) return;

        if(root.isTerminating) {
            System.out.println(prefix);
        }

        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                char nextChar = (char)(i + 'a');
                printAllWords(root.children[i], prefix + nextChar);
            }
        }
    }

    /* ----------- Main autoComplete ----------- */
    public void autoComplete(ArrayList<String> input, String word) {

        // Step 1: Insert all words
        for(String str : input) {
            add(str);
        }

        // Step 2: Traverse till prefix node
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                return; // no words found
            }
            current = current.children[index];
        }

        // Step 3: Print all words from this node
        printAllWords(current, word);
    }
}