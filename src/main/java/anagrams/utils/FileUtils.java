package anagrams.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileUtils {
	private static final String MISSING_FILE_MSG = "Mentioned file does not exists: %s ";

	public static File getFile(String pathToFile) throws IOException {
		ClassLoader classLoader = FileUtils.class.getClassLoader();
		URL urlToFile = classLoader.getResource(pathToFile);
		if (urlToFile == null) {
			throw new IOException(String.format(MISSING_FILE_MSG, pathToFile));
		}
		File file = new File(urlToFile.getFile());
		return file;
	}
}
