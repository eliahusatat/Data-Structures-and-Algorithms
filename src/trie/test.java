package trie;

public class test {

	public static void main(String[] args) {
		 String keys[] = {"the", "a", "there", "answer", "any", 
                 "by", "bye", "their"};
		 trie t = new trie();
		 for (String k : keys) {
			t.insert(k);
		}
		 System.out.println(t.search("eliahu"));
		 System.out.println(t.search("there"));
		 System.out.println(t.search("bye"));
		 System.out.println(t.search("byes"));

	}

}
