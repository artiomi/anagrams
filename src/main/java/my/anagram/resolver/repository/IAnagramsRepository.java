package my.anagram.resolver.repository;

import java.util.Collections;
import java.util.Set;

import my.anagram.resolver.service.EntryKey;

/**
 * Interface responsible for storing and manipulation with entries
 */
public interface IAnagramsRepository {
	/**
	 * Check if in repository exists entry for provided key
	 * 
	 * @param key
	 * @return boolean if entry with such key exists in repository
	 */
	public boolean conainsKey(EntryKey key);

	/**
	 * Return repository entries for provided key, should return
	 * Collections.emptySet() if no entry found
	 * 
	 * @param key
	 * @return Set of words registered for specified key
	 */
	public Set<String> getEntriesForKey(EntryKey key);

	/**
	 * Creates new repository entry using provided key and map to it word value
	 * 
	 * @param key
	 * @param word
	 */
	public void createNewEntry(EntryKey key, String word);

	/**
	 * Update existing repository entry by adding new value to entry with specified
	 * key
	 * 
	 * @param key
	 * @param word
	 */
	public void addWordToEntry(EntryKey key, String word);

	/**
	 * Remove from repository entry mapped to provided key
	 * 
	 * @param key
	 * 
	 */
	public void removeEntry(EntryKey key);

	/**
	 * @return number of entries in repository
	 */
	public int entriesCount();

	/**
	 * Get set of all EntryKeys from repository. If repository contains too many
	 * keys use method:getNextBatchOfKeys
	 * 
	 * @return Set of all EntryKey from repository
	 */
	public Set<EntryKey> getAllKeys();

	/**
	 * Use this method in case of large amount of elemets in repository
	 * 
	 * @param Set
	 *            of EntryKey from repository which starts at startIndex and have
	 *            defined batchSize
	 * @return
	 */
	default Set<EntryKey> getNextBatchOfKeys(int startIndex, int batchSize) {
		if (batchSize < 1) {
			throw new IllegalArgumentException("Provided batch is less then 1");
		}
		return Collections.emptySet();
	}
}
