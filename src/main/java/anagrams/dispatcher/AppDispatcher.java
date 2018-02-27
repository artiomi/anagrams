package anagrams.dispatcher;

import java.util.List;

import anagrams.algoritm.IWordsProcessor;
import anagrams.reader.ReadableSource;
import anagrams.report.IProcessReport;

public class AppDispatcher {
	private ReadableSource reader;
	private IWordsProcessor analyzer;
	private IProcessReport reportProcessor;

	public AppDispatcher(ReadableSource reader, IWordsProcessor analyzer, IProcessReport reportProcessor) {
		this.reader = reader;
		this.analyzer = analyzer;
		this.reportProcessor = reportProcessor;
	}

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

	public void prepareReport() {
		reportProcessor.prepareReport();
	}
}
