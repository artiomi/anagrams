package anagrams.reader;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class TestTextReader {
	private static final String MISSING_FILE = "simpleFile.txt";
	private static final String TEST_FILE = "sample_test.txt";
	private static final String MSG_EMPTY_FILE = "Source file is empty";

	@Test
	public void testReadContent() throws IOException {
		ResourceReader txtReader = new TxtReader(TEST_FILE);
		List<String> lines = txtReader.readNextBatch(10);
		assertFalse(MSG_EMPTY_FILE, lines.isEmpty());
	}

	@Test(expected = IOException.class)
	public void testMissingFile() throws IOException {
		ResourceReader txtReader = new TxtReader(MISSING_FILE);
		txtReader.readNextBatch(10);

	}
}
