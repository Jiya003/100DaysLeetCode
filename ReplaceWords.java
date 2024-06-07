/*
Question no. 648

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"

 

Constraints:

*/
class ReplaceWords {
    Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for(String word : dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String []  input = sentence.split(" ");
        for(String i : input){
            result.append(search(i));
            result.append(" ");
        }
        return result.toString().trim();
    }
    public String search(String word){
        Trie node = root;
        int j = 0;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            j++;
            if(node.children[i] == null){
                return word;
            }else if(node.children[i].isEnd){
                return word.substring(0, j);
            }else{
                node = node.children[i];
            }
            
        }
        return word;

    }
    public void insert(String word){
        Trie node = root;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null){
                node.children[i] = new Trie();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }
}
class Trie{
    Trie [] children;
    boolean isEnd;
    public Trie(){
        children = new Trie[26];
        isEnd =false;
    }
} 
