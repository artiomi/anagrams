package my.anagram.resolver.dispatcher;

import java.util.List;

import my.anagram.resolver.processor.IWordsProcessor;
import my.anagram.resolver.reader.IWordsReader;
import my.anagram.resolver.report.IExecutionReport;

/**
 * Class which glues all application elements
 */
public class AppDispatcher {
	private IWordsReader reader;
	private IWordsProcessor analyzer;
	private IExecutionReport executionReport;

	/**
	 * During initialization provide required components
	 * 
	 * @param reader
	 *            - responsible for source reading
	 * @param analyzer
	 *            - responsible for elements storing
	 * @param executionReport
	 *            - responsible for report display
	 */
	public AppDispatcher(IWordsReader reader, IWordsProcessor analyzer, IExecutionReport executionReport) {
		this.reader = reader;
		this.analyzer = analyzer;
		this.executionReport = executionReport;
	}

	/**
	 * Manage to find anagrams in defined source
	 * 
	 * @throws Exception
	 */
	public void processAnagrams() throws Exception {
		List<String> words = null;
		try {
			reader.initReader();
			while (reader.hasMore()) {
				words = reader.readNextBatch(2);
				analyzer.processWords(words);
			}
		} finally {
			reader.closeReader();
		}
	}

	/**
	 * Provide execution report
	 */
	public void provideExecutionReport() {
		executionReport.presentReport();
	}
}
