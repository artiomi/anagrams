package my.anagram.resolver;

import my.anagram.resolver.dispatcher.AppDispatcher;
import my.anagram.resolver.processor.AnagramsProcessor;
import my.anagram.resolver.processor.IWordsProcessor;
import my.anagram.resolver.reader.IWordsReader;
import my.anagram.resolver.reader.TxtReader;
import my.anagram.resolver.registry.CollectionRegistry;
import my.anagram.resolver.registry.IWordsRegistry;
import my.anagram.resolver.report.ConsoleReport;
import my.anagram.resolver.report.IExecutionReport;

public class MainAnagramsResolver {
	public static void main(String... args) throws Exception {
		System.out.println("Start");
		
		IWordsRegistry registry = new CollectionRegistry();
		IWordsProcessor processor = new AnagramsProcessor(registry);
		IExecutionReport reporter = new ConsoleReport(registry);
		IWordsReader readableSource = new TxtReader("sample.txt");

		AppDispatcher disaptcher = new AppDispatcher(readableSource, processor, reporter);
		disaptcher.processAnagrams();
		disaptcher.provideExecutionReport();
		
		System.out.println("end");
	}
}
