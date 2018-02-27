package anagrams.report;

import java.util.Set;

import anagrams.registry.EntryKey;
import anagrams.registry.IWordsRegistry;

public class ConsoleReport implements IProcessReport {
	private IWordsRegistry registry;

	public ConsoleReport(IWordsRegistry registry) {
		this.registry = registry;
	}

	public void prepareReport() {
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
