package my.anagram.resolver.report;

import java.util.Set;

import my.anagram.resolver.registry.EntryKey;
import my.anagram.resolver.registry.IWordsRegistry;

/**
 * 
 * Display execution report as console output, using IWordsRegistry entries
 *
 */
public class ConsoleReport implements IExecutionReport {
	private IWordsRegistry registry;

	public ConsoleReport(IWordsRegistry registry) {
		this.registry = registry;
	}

	@Override
	public void presentReport() {
		System.out.println("=========Result==========");
		Set<EntryKey> keys = registry.getAllKeys();
		for (EntryKey key : keys) {
			Set<String> anagrams = registry.getEntriesForKey(key);
			if (anagrams.size() > 1) {
				String report = String.join(" ", anagrams);
				System.out.println(report);
			}
		}
		System.out.println("========================");
	}
}
