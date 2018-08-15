package Strings;

public class FindNextWord extends trie {
	// create dictionary
	public void createDirt(String s) {
		trie t = new trie();
		for (int i = 0; i < s.length(); i++) {
			t.addWord(s.substring(0, i));
		}
	}

}
