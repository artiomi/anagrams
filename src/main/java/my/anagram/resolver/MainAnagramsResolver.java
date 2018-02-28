package my.anagram.resolver;

import my.anagram.resolver.dispatcher.AppDispatcher;
import my.anagram.resolver.reader.ISourceReader;
import my.anagram.resolver.reader.TxtReader;
import my.anagram.resolver.report.ConsoleReport;
import my.anagram.resolver.report.IReportProvider;
import my.anagram.resolver.repository.CollectionRepository;
import my.anagram.resolver.repository.IAnagramsRepository;
import my.anagram.resolver.service.AnagramsRegisterService;
import my.anagram.resolver.service.IRegistryService;

public class MainAnagramsResolver {
	private static final String SRC_FILE = "sample.txt";

	public static void main(String... args) throws Exception {
		System.out.println("Start.");

		IAnagramsRepository repository = new CollectionRepository();
		IRegistryService registryService = new AnagramsRegisterService(repository);
		IReportProvider reporter = new ConsoleReport(repository);
		ISourceReader readableSource = new TxtReader(SRC_FILE);

		AppDispatcher disaptcher = new AppDispatcher(readableSource, registryService, reporter);
		disaptcher.processAnagrams();
		disaptcher.provideExecutionReport();

		System.out.println("End.");
	}
}
