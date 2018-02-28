package my.anagram.resolver.reader;

import java.io.IOException;
import java.util.List;

/**
 * Read words from a source
 *
 */
public interface IWordsReader {

	/**
	 * Call this methods first, it is used for readers related initialization
	 * 
	 * @throws Exception
	 */
	public void initReader() throws Exception;

	/**
	 * Check if reader allows data reading
	 * 
	 * @return
	 */
	public boolean hasMore();

	/**
	 * Required method to be called to close reader related resourcies
	 * 
	 * @throws Exception
	 */
	public void closeReader() throws Exception;

	/**
	 * Reading batch of elements from source
	 * 
	 * @param batchSize
	 * @return list of elements delimited by passed batch
	 * @throws IOException
	 */
	public List<String> readNextBatch(int batchSize) throws Exception;

}
