package anagrams;

import anagrams.algoritm.AnagramsProcessor;
import anagrams.algoritm.IWordsProcessor;
import anagrams.dispatcher.AppDispatcher;
import anagrams.reader.ReadableSource;
import anagrams.reader.TxtReader;
import anagrams.registry.CollectionRegistry;
import anagrams.registry.IWordsRegistry;
import anagrams.report.ConsoleReport;
import anagrams.report.IProcessReport;

public class MainRunner {
	public static void main(String... args) throws Exception {
		System.out.println("Start");
		
		IWordsRegistry registry = new CollectionRegistry();
		IWordsProcessor processor = new AnagramsProcessor(registry);
		IProcessReport reporter = new ConsoleReport(registry);
		ReadableSource readableSource = new TxtReader("sample.txt");

		AppDispatcher disaptcher = new AppDispatcher(readableSource, processor, reporter);
		disaptcher.processAnagrams();
		disaptcher.prepareReport();
		
		System.out.println("end");
	}
}
