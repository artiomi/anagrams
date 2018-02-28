package my.anagram.resolver.registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionRegistry implements IWordsRegistry {
	private final Map<EntryKey, Set<String>> elementsRegistry = new HashMap<>();

	@Override
	public Set<String> getEntriesForKey(EntryKey key) {
		if (!elementsRegistry.containsKey(key)) {
			return Collections.emptySet();
		} else {
			return new TreeSet<String>(elementsRegistry.get(key));
		}
	}

	@Override
	public boolean conainsKey(EntryKey key) {
		if (elementsRegistry.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Set<EntryKey> getAllKeys() {
		return new HashSet<EntryKey>(elementsRegistry.keySet());
	}

	@Override
	public void createNewEntry(EntryKey key, String word) {
		Set<String> entry = new TreeSet<>();
		entry.add(word);
		elementsRegistry.put(key, entry);
	}

	@Override
	public void addWordToEntry(EntryKey key, String value) {
		elementsRegistry.get(key).add(value);
	}

	@Override
	public void removeEntry(EntryKey key) {
		elementsRegistry.remove(key);
	}

	@Override
	public int countEntries() {
		return elementsRegistry.keySet().size();
	}

}
