package my.anagram.resolver.repository;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import my.anagram.resolver.service.AnagramsRegisterService;
import my.anagram.resolver.service.EntryKey;
import my.anagram.resolver.service.IRegistryService;

public class TestCollectionRepository {
	private IAnagramsRepository repositroy;
	private IRegistryService registryService;
	private static List<String> testValues = Arrays.asList("cat", "act", "cat");
	private static List<String> newEntryValues = Arrays.asList("tar", "rat");
	private static List<String> updateValues = Arrays.asList("tac");

	@Before
	public void beforeTest() throws Exception {
		repositroy = new CollectionRepository();
		registryService = new AnagramsRegisterService(repositroy);
		registryService.registerAnagrams(testValues);
	}

	@Test
	public void testNoDuplicatesInRegistry() {
		Set<EntryKey> allKeys = repositroy.getAllKeys();
		EntryKey firstKey = allKeys.toArray(new EntryKey[1])[0];
		Set<String> valuesForKey = repositroy.getEntriesForKey(firstKey);
		assertTrue(valuesForKey.size() == 2);
	}

	@Test
	public void testCreateNewEntry() {
		registryService.registerAnagrams(newEntryValues);
		Set<EntryKey> allKeys = repositroy.getAllKeys();
		assertTrue(allKeys.size() == 2);
	}

	@Test
	public void testUpdateNewEntry() {
		registryService.registerAnagrams(updateValues);
		Set<EntryKey> allKeys = repositroy.getAllKeys();
		EntryKey firstKey = allKeys.toArray(new EntryKey[1])[0];
		Set<String> valuesForKey = repositroy.getEntriesForKey(firstKey);
		assertTrue(valuesForKey.size() == 3);
	}

	@Test
	public void testRemoveNewEntry() {
		Set<EntryKey> allKeys = repositroy.getAllKeys();
		EntryKey firstKey = allKeys.toArray(new EntryKey[1])[0];
		repositroy.removeEntry(firstKey);
		assertTrue(repositroy.getAllKeys().size() == 0);
	}

}
