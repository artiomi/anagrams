package my.anagram.resolver.repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
		Set<String> entry = new TreeSet<>();
		entry.add(word);
		elementsRepository.put(key, entry);
	}

	@Override
	public void addWordToEntry(EntryKey key, String value) {
		elementsRepository.get(key).add(value);
	}

	@Override
	public void removeEntry(EntryKey key) {
		elementsRepository.remove(key);
	}

	@Override
	public int entriesCount() {
		return elementsRepository.keySet().size();
	}

	@Override
	public Set<EntryKey> getNextBatchOfKeys(int batchSize) {
		if (batchSize < 1) {
			throw new IllegalArgumentException("Provided batch is less then 1");
		}
		return Collections.emptySet();
	}

}
