package anagrams.reader;

import java.io.IOException;
import java.util.List;

/**
 * Read words from a source
 *
 */
public interface ReadableSource {

	public void initReader() throws Exception;

	public boolean hasMore();
	
	public void closeReader() throws Exception;

	/**
	 * @param batchSize
	 * @return list of elements delimited by passed batch
	 * @throws IOException
	 */
	public List<String> readNextBatch(int batchSize) throws Exception;

}
