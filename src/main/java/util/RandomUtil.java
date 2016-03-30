package util;

import java.util.*;
import java.util.stream.IntStream;

public class RandomUtil {

	public static final Random rand = new Random();
	
	private static final char[] chars = new char[26];
	static {
		IntStream.range(0, 26).forEach(n->chars[n] = (char) (n + 'a'));
	}
	
	public static int nextInt(int n) {
		return rand.nextInt(n);
	}
	
	public static long nextLong(long n) {
		return rand.nextLong();
	}
	
	public static char nextLetter() {
		return chars[rand.nextInt(26)];
	}
	
	public static String nextString(int size) {
		StringBuilder sb = new StringBuilder();
		for (int n=0; n<size; ++n) {
			sb.append(nextLetter());
		}
		return sb.toString();
	}
}
