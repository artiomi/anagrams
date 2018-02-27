package anagrams.registry;

import java.util.Set;

public interface IWordsRegistry {
	public boolean conainsKey(EntryKey key);

	public Set<String> getEntriesForKey(EntryKey key);

	public void createNewEntry(EntryKey key, Set<String> entry);

	public void addNewElement(EntryKey key, String value);

	public void removeEntry(EntryKey key);

	public Set<EntryKey> getAllKeys();
}
