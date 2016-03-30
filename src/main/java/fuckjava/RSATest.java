package fuckjava;

import java.util.*;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;

@SuppressWarnings("unused")
public class RSATest {

	public static void main(String[] args) throws Throwable {
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
		gen.initialize(1024);
		KeyPair keyPair = gen.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
		
		System.out.println("gen class = " + gen.getClass().getName() ); // java.security.KeyPairGenerator$Delegate
		System.out.println("privateKey class = " + privateKey.getClass().getName() ); // sun.security.rsa.RSAPrivateCrtKeyImpl
		System.out.println("publicKey class = " + publicKey.getClass().getName() ); // sun.security.rsa.RSAPublicKeyImpl
		
		sun.security.rsa.RSAPublicKeyImpl xx = new sun.security.rsa.RSAPublicKeyImpl(publicKey.getEncoded());
		RSAPrivateKey newKey = sun.security.rsa.RSAPrivateCrtKeyImpl.newKey(privateKey.getEncoded());
		
		System.out.println(publicKey.equals(xx));
		System.out.println(privateKey.equals(newKey));
		
		byte[] srcBytes = "fuck my life".getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encodeBytes  = cipher.doFinal(srcBytes);
		
//		{
//			System.out.println("\n/******************************************************/");
//			Encoder encoder = Base64.getUrlEncoder();
//			byte[] encodeBytesBase64 = encoder.encode(encodeBytes);
//			System.out.println();
//			System.out.println(new String(encodeBytesBase64));
//			System.out.println();
//			
//			Decoder decoder = Base64.getUrlDecoder();
//			byte[] decodeBytesBase64 = decoder.decode(encodeBytesBase64);
//			System.out.println(new String(decodeBytesBase64));
//			System.out.println("\n/******************************************************/");
//		}
		
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decodeBytes = cipher.doFinal(encodeBytes);
		System.out.println(new String(decodeBytes));
	}

}
