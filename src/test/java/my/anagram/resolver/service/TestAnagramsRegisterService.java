package my.anagram.resolver.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.anagram.resolver.repository.CollectionRepository;
import my.anagram.resolver.repository.IAnagramsRepository;

public class TestAnagramsRegisterService {
	private IAnagramsRepository repositroy;
	private IRegistryService registryService;
	private List<String> testValues = Arrays.asList("cat", "tac", "cat");

	@Before
	public void beforeTest() throws Exception {
		repositroy = new CollectionRepository();
		registryService = new AnagramsRegisterService(repositroy);
		registryService.registerAnagrams(testValues);
	}

	@Test
	public void testKeyIsValid() throws Exception {
		Set<EntryKey> allKeys = repositroy.getAllKeys();
		assertTrue(allKeys.size() == 1);
	}

}
