package my.anagram.resolver.dispatcher;

import java.util.List;

import my.anagram.resolver.reader.ISourceReader;
import my.anagram.resolver.report.IReportProvider;
import my.anagram.resolver.service.IRegistryService;

/**
 * Glues all application elements
 */
public class AppDispatcher {
	private ISourceReader reader;
	private IRegistryService registryService;
	private IReportProvider reportProvider;

	/**
	 * During initialization provide required components
	 * 
	 * @param reader
	 *            - responsible for source reading
	 * @param registryService
	 *            - responsible for elements storing
	 * @param reportProvider
	 *            - responsible for report display
	 */
	public AppDispatcher(ISourceReader reader, IRegistryService registryService, IReportProvider reportProvider) {
		this.reader = reader;
		this.registryService = registryService;
		this.reportProvider = reportProvider;
	}

	/**
	 * Manage to find anagrams in defined source and register them
	 * 
	 * @throws Exception
	 */
	public void processAnagrams() throws Exception {
		System.out.println("AppDispatcher.processAnagrams() - Started.");
		List<String> words = null;
		try {
			reader.initReader();
			while (reader.hasMore()) {
				words = reader.readNextBatch(2);
				registryService.registerAnagrams(words);
			}
		} finally {
			reader.closeReader();
		}
		System.out.println("AppDispatcher.processAnagrams() - completed succesfully.");

	}

	/**
	 * Provide execution report
	 */
	public void provideExecutionReport() {
		System.out.println("AppDispatcher.provideExecutionReport() - Started.");
		reportProvider.prepareReport();
		System.out.println("AppDispatcher.provideExecutionReport() - completed succesfully.");

	}
}
