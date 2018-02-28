package my.anagram.resolver.reader;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import my.anagram.resolver.reader.ISourceReader;
import my.anagram.resolver.reader.TxtReader;

public class TestTextReader {
	private static final String TEST_FILE = "sample_test.txt";
	private static final String MSG_EMPTY_FILE = "Source file should not be is empty";
	private ISourceReader txtReader;

	@Before
	public void beforeTest() throws Exception {
		txtReader = new TxtReader(TEST_FILE);
		txtReader.initReader();
	}

	@Test
	public void testReadContent() throws Exception {

		List<String> lines = txtReader.readNextBatch(10);
		assertFalse(MSG_EMPTY_FILE, lines.isEmpty());
	}

	@After
	public void afterTest() throws Exception {
		txtReader.closeReader();
	}
}
