package anagrams.reader;

import java.io.IOException;
import java.util.List;

/**
 * Read words from a source
 *
 */
public interface ResourceReader {
	/**
	 * @param batchSize
	 * @return list of elemnets delimited by passed batch
	 * @throws IOException 
	 */
	List<String> readNextBatch(int batchSize) throws IOException;
}
