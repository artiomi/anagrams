package my.anagram.resolver.service;

import java.util.List;

import my.anagram.resolver.repository.IAnagramsRepository;

public class AnagramsRegisterService implements IRegistryService {

	private IAnagramsRepository repository;

	public AnagramsRegisterService(IAnagramsRepository repository) {
		this.repository = repository;
	}

	@Override
	public void registerAnagrams(List<String> words) {
		for (String word : words) {
			EntryKey key = new EntryKey(word);
			boolean conainsKey = repository.conainsKey(key);
			if (conainsKey) {
				repository.addWordToEntry(key, word);
			} else {
				repository.createNewEntry(key, word);
			}

		}
	}

}
