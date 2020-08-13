package trie;


/**
 * this class represent a single node for trie
 * @author Eliahu Satat
 */
public class TNode {
	static final int ALPHABET_SIZE = 26; // the size of the English alphabet
	public TNode[] children = new TNode[ALPHABET_SIZE]; // Every node can have child in every alphabet leter
	public boolean isEndOfWord; // if this node is end of word

	public TNode() {
		isEndOfWord = false;
		for (int i = 0; i < ALPHABET_SIZE; i++) 
			children[i] = null; 
	} 
}


