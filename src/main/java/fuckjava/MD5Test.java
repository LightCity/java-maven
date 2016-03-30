package fuckjava;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
	
	// fe419f322910227dad60dd0ac70a08ab

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest instance = MessageDigest.getInstance("MD5");
		byte[] ba = ("!@p542243_" + "123456").getBytes("UTF-8");
		p(ba);
		instance.update(ba);
		p(ba);
		byte[] ba2 = instance.digest();
		p(ba2);
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] output = new char[ba2.length * 2];
		for (int n=0; n<ba2.length; ++n) {
			byte b = ba2[n];
			output[n * 2] = hexDigits[(b>>>4) & 0xf]; 
			output[n * 2 + 1] = hexDigits[b & 0xf]; 
		}
		System.out.println(new String(output));
	}

	static void p(byte[] ba) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (byte b : ba) {
			sb.append(b + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(']');
		System.out.println(sb);
	}
}
