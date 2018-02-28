package my.anagram.resolver.report;

import java.util.Set;

import my.anagram.resolver.repository.IAnagramsRepository;
import my.anagram.resolver.service.EntryKey;

/**
 * 
 * Display execution report as console output, using IWordsRegistry entries
 *
 */
public class ConsoleReport implements IReportProvider {
	private IAnagramsRepository repository;

	public ConsoleReport(IAnagramsRepository registry) {
		this.repository = registry;
	}

	@Override
	public void prepareReport() {
		System.out.println("=========Result==========");
		Set<EntryKey> keys = repository.getAllKeys();
		for (EntryKey key : keys) {
			Set<String> anagrams = repository.getEntriesForKey(key);
			if (anagrams.size() > 1) {
				String report = String.join(" ", anagrams);
				System.out.println(report);
			}
		}
		System.out.println("========================");
	}
}
