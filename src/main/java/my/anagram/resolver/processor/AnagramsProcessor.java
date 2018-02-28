package my.anagram.resolver.processor;

import java.util.List;

import my.anagram.resolver.registry.EntryKey;
import my.anagram.resolver.registry.IWordsRegistry;

public class AnagramsProcessor implements IWordsProcessor {

	private IWordsRegistry registry;

	public AnagramsProcessor(IWordsRegistry registry) {
		this.registry = registry;
	}

	@Override
	public void processWords(List<String> words) {
		for (String word : words) {
			EntryKey key = new EntryKey(word);
			boolean conainsKey = registry.conainsKey(key);
			if (conainsKey) {
				registry.addWordToEntry(key, word);
			} else {
				registry.createNewEntry(key, word);
			}

		}
	}

}
