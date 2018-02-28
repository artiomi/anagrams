package my.anagram.resolver.service;

import java.util.List;

/**
 * Service responsible for anagrams registration
 */
public interface IRegistryService {

	/**
	 * Register anagrams from provided words
	 * 
	 * @param words
	 */
	public void registerAnagrams(List<String> words);

}
