package anagrams.algoritm;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import anagrams.registry.EntryKey;
import anagrams.registry.IWordsRegistry;

public class AnagramsAnalyzer implements ElemtsAnalyzer {

	private IWordsRegistry registry;

	public AnagramsAnalyzer(IWordsRegistry registry) {
		this.registry = registry;
	}

	@Override
	public void analyzeWords(List<String> words) {
		for (String word : words) {
			EntryKey key = new EntryKey(word);
			boolean conainsKey = registry.conainsKey(key);
			if (conainsKey) {
				registry.addNewElement(key, word);
			} else {
				Set<String> entry = new TreeSet<>();
				entry.add(word);
				registry.createNewEntry(key, entry);
			}

		}
	}

}
