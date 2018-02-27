package anagrams.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TxtReader implements ResourceReader {

	private static final String MISSING_FILE_MSG = "Mentioned file does not exists: %s ";
	private String pathToFile;
	private static int DEFAULT_BACH_SIZE = 10;

	public TxtReader(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	public List<String> readNextBatch(int batchSize) throws IOException {
		List<String> result = new ArrayList<>();
		File sourceFile = getFile(pathToFile);
		try (BufferedReader bReader = new BufferedReader(new FileReader(sourceFile))) {

			String currentLine;
			while ((currentLine = bReader.readLine()) != null) {
				result.add(currentLine.trim());
			}

		}
		return result;
	}

	private File getFile(String pathToFile) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL urlToFile = classLoader.getResource(pathToFile);
		if (urlToFile == null) {
			throw new IOException(String.format(MISSING_FILE_MSG, pathToFile));
		}
		File file = new File(urlToFile.getFile());
		return file;
	}

}
