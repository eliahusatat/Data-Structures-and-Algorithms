package trie;


/**
 * this class represent a trie 
 * @author Eliahu Satat
 */
public class trie {
	private TNode root;
	
	
	/**
	 * constructor
	 */
	public trie() {
		root = new TNode();
	}
	
	/**
	 * insert word to the trie 
	 */
	 public void insert(String key) 
	    { 
	        int level; 
	        int length = key.length(); 
	        int index; 
	       
	        TNode current = root; 
	       
	        for (level = 0; level < length; level++) // run over the word
	        { 
	            index = key.charAt(level) - 'a'; // convert the letter to his number a=0 b=1...
	            if (current.children[index] == null) //if he doesn't have this letter child 
	                current.children[index] = new TNode();  // make this letter 
	       
	            current = current.children[index]; 
	        } 
	       
	        // mark last node as leaf = in this node end of word
	        current.isEndOfWord = true; 
	    } 
	 
	 
		/**
		 * search if word is in the trie 
		 */
	   public boolean search(String key) 
	    { 
	        int level; 
	        int length = key.length(); 
	        int index; 
	        TNode current = root; 
	       
	        for (level = 0; level < length; level++) // run over the word
	        { 
	            index = key.charAt(level) - 'a'; // convert to the number of the letter a=0 , b=1..
	       
	            if (current.children[index] == null) // if its stop in the middle of the word - doesn't in the trie
	                return false; 
	       
	            current = current.children[index]; // go to the next letter
	        } 
	       
	        return (current != null && current.isEndOfWord); // if we have the last letter and this letter is the end of word this word is in the trie
	    } 

}
