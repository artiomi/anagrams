package anagrams.registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionRegistry implements IWordsRegistry {
	private Map<EntryKey, Set<String>> elementsRegistry = new HashMap<>();

	@SuppressWarnings("unchecked")
	public Set<String> getEntriesForKey(EntryKey key) {
		if (!elementsRegistry.containsKey(key)) {
			return Collections.EMPTY_SET;
		} else {
			return new TreeSet<String>(elementsRegistry.get(key));
		}
	}

	public boolean conainsKey(EntryKey key) {
		if (elementsRegistry.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}

	public Set<EntryKey> getAllKeys() {
		return elementsRegistry.keySet();
	}

	public void createNewEntry(EntryKey key, Set<String> entry) {
		elementsRegistry.put(key, entry);
	}

	public void addNewElement(EntryKey key, String value) {
		elementsRegistry.get(key).add(value);
	}

	public void removeEntry(EntryKey key) {
		elementsRegistry.remove(key);
	}

	/*
	 * public void registerWord(String word) {
	 * 
	 * char[] wordAsArray = word.toCharArray(); Arrays.parallelSort(wordAsArray);
	 * Optional<Set<String>> anagramsOption = getWordAnagrams(wordAsArray); if
	 * (anagramsOption.isPresent()) { Set<String> list = anagramsOption.get();
	 * list.add(word); } else { Set<String> value = new HashSet<String>();
	 * elementsRegistry.put(wordAsArray, value); } }
	 * 
	 * private Optional<Set<String>> getWordAnagrams(char[] wordAsArray) {
	 * Optional<Set<String>> valuesOption = elementsRegistry.entrySet().stream()
	 * .filter(entry -> Arrays.equals(wordAsArray, entry.getKey())).map(entry ->
	 * entry.getValue()).findFirst(); return valuesOption; }
	 */

}
