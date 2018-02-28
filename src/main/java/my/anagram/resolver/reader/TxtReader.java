package my.anagram.resolver.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import my.anagram.resolver.utils.FileUtils;

/**
 * Read words from provided .txt file
 */
public class TxtReader implements ISourceReader {

	private static final String MSG_NULL_READER = "Reader not instantiated.";
	private String pathToFile;
	private static int DEFAULT_BACH_SIZE = 100;
	private boolean hasMoreFlag = true;
	private BufferedReader bReader;

	public TxtReader(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	@Override
	public void initReader() throws IOException {
		File sourceFile = FileUtils.getFile(pathToFile);
		bReader = new BufferedReader(new FileReader(sourceFile));
		System.out.println("TxtReader.initReader() - Initialized.");

	}

	@Override
	public boolean hasMore() {
		if (bReader == null) {
			throw new RuntimeException(MSG_NULL_READER);
		}
		return hasMoreFlag;
	}

	@Override
	public List<String> readNextBatch(int batchSize) throws IOException {
		System.out.println("TxtReader.readNextBatch(): read batch with size: " + batchSize);
		List<String> result = new ArrayList<>();
		batchSize = batchSize > 0 ? batchSize : DEFAULT_BACH_SIZE;
		String currentLine;
		try {
			for (int i = batchSize; i > 0; i--) {
				currentLine = bReader.readLine();
				if (currentLine == null) {
					hasMoreFlag = false;
					break;
				}
				result.add(currentLine.trim());
			}

		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	@Override
	public void closeReader() throws IOException {
		if (bReader != null) {
			bReader.close();
		}
		System.out.println("TxtReader.closeReader() - Closed.");

	}

}
