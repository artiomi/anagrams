package anagrams.dispatcher;

import java.io.IOException;
import java.util.List;

import anagrams.algoritm.ElemtsAnalyzer;
import anagrams.reader.ResourceReader;
import anagrams.registry.IWordsRegistry;

public class AppDispatcher {
	private ResourceReader reader;
	private ElemtsAnalyzer analyzer;
	private IWordsRegistry elementsRegistry;

	public AppDispatcher(ResourceReader reader, IWordsRegistry elementsRegistry, ElemtsAnalyzer analyzer) {
		this.reader = reader;
		this.analyzer = analyzer;
		this.elementsRegistry = elementsRegistry;
	}

	public void processElements() throws IOException {
		List<String> elements = reader.readNextBatch(10);
		analyzer.analyzeWords(elements);
	}
}
