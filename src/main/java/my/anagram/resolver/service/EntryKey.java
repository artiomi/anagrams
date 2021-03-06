package my.anagram.resolver.service;

import java.util.Arrays;

/**
 * Represents key logic
 */
public class EntryKey {

	private char[] keyValue;

	EntryKey(String word) {
		char[] wordAsArray = word.toCharArray();
		Arrays.parallelSort(wordAsArray);
		this.keyValue = wordAsArray;
	}

	public char[] getKeyValue() {
		return keyValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(keyValue);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntryKey other = (EntryKey) obj;
		if (!Arrays.equals(keyValue, other.keyValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntryKey [keyValue=" + Arrays.toString(keyValue) + "]";
	}
}
