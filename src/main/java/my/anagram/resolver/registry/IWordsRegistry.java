package my.anagram.resolver.registry;

import java.util.Collections;
import java.util.Set;

/**
 * Interface responsible for storing and manipulation with entries
 */
public interface IWordsRegistry {
	/**
	 * Check if in registry exists entry for provided key
	 * 
	 * @param key
	 * @return
	 */
	public boolean conainsKey(EntryKey key);

	/**
	 * Return registry entries for provided key, should return
	 * Collections.emptySet() if no entry found
	 * 
	 * @param key
	 * @return
	 */
	public Set<String> getEntriesForKey(EntryKey key);

	/**
	 * Creates new registry entry using provided key and map to it word value
	 * 
	 * @param key
	 * @param word
	 */
	public void createNewEntry(EntryKey key, String word);

	/**
	 * Update existing registry entry by adding new value to entry with specified
	 * key
	 * 
	 * @param key
	 * @param word
	 */
	public void addWordToEntry(EntryKey key, String word);

	/**
	 * Remove from registry entry mapped to provided key
	 * 
	 * @param key
	 */
	public void removeEntry(EntryKey key);

	/**
	 * @return number of entries in registry
	 */
	public int countEntries();

	/**
	 * Get set of all EntryKeys from registry. If registry contains too many keys
	 * use method:getNextBatchOfKeys
	 * 
	 * @return
	 */
	public Set<EntryKey> getAllKeys();

	/**
	 * Return a batch of keys of size=batchSize. Throws exception if
	 * batchSize<1.Should return Collections.emptySet() if entry is empty
	 * 
	 * @param batchSize
	 * @return
	 */
	default Set<EntryKey> getNextBatchOfKeys(int batchSize) {
		if (batchSize < 1) {
			throw new IllegalArgumentException("Provided batch is less then 1");
		}
		return Collections.emptySet();
	};
}
