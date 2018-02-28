package anagrams.reader;

import java.io.IOException;

import org.junit.Test;

import my.anagram.resolver.reader.IWordsReader;
import my.anagram.resolver.reader.TxtReader;

public class TestTextReader {
	private static final String MISSING_FILE = "simpleFile.txt";
	private static final String TEST_FILE = "sample_test.txt";
	private static final String MSG_EMPTY_FILE = "Source file is empty";

	@Test
	public void testReadContent() throws IOException {
		IWordsReader txtReader = new TxtReader(TEST_FILE);
		//List<String> lines = txtReader.readNextBatch(10);
		//assertFalse(MSG_EMPTY_FILE, lines.isEmpty());
	}

	@Test(expected = IOException.class)
	public void testMissingFile() throws IOException {
		IWordsReader txtReader = new TxtReader(MISSING_FILE);
		//txtReader.readNextBatch(10);

	}
}
