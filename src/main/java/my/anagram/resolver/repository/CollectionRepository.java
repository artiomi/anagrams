package my.anagram.resolver.repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import my.anagram.resolver.service.EntryKey;

public class CollectionRepository implements IAnagramsRepository {
	private final Map<EntryKey, Set<String>> elementsRepository = new LinkedHashMap<>();

	@Override
	public Set<String> getEntriesForKey(EntryKey key) {
		if (!elementsRepository.containsKey(key)) {
			return Collections.emptySet();
		} else {
			return new TreeSet<String>(elementsRepository.get(key));
		}
	}

	@Override
	public boolean conainsKey(EntryKey key) {
		if (elementsRepository.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Set<EntryKey> getAllKeys() {
		return new HashSet<EntryKey>(elementsRepository.keySet());
	}

	@Override
	public void createNewEntry(EntryKey key, String word) {
		System.out.println(String.format("Create new entry for key: %s and word: [%s]", key, word));
		Set<String> entry = new TreeSet<>();
		entry.add(word);
		elementsRepository.put(key, entry);
	}

	@Override
	public void addWordToEntry(EntryKey key, String value) {
		System.out.println(String.format("Add new word [%s] to entry with key: %s ", value, key));
		elementsRepository.get(key).add(value);
	}

	@Override
	public void removeEntry(EntryKey key) {
		System.out.println(String.format("Remove entry specified for key: %s ", key));
		elementsRepository.remove(key);
	}

	@Override
	public int entriesCount() {
		return elementsRepository.keySet().size();
	}

}
