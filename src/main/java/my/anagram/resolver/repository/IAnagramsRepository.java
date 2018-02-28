package my.anagram.resolver.repository;

import java.util.Collections;
import java.util.Set;

/**
 * Interface responsible for storing and manipulation with entries
 */
public interface IAnagramsRepository {
	/**
	 * Check if in repository exists entry for provided key
	 * 
	 * @param key
	 * @return
	 */
	public boolean conainsKey(EntryKey key);

	/**
	 * Return repository entries for provided key, should return
	 * Collections.emptySet() if no entry found
	 * 
	 * @param key
	 * @return
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
	 */
	public void removeEntry(EntryKey key);

	/**
	 * @return number of entries in repository
	 */
	public int entriesCount();

	/**
	 * Get set of all EntryKeys from repository. If repository contains too many keys
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
	public  Set<EntryKey> getNextBatchOfKeys(int batchSize) ;
}
