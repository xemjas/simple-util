package com.lumina.simpleutil;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * @author Xemjas
 *
 */
public class HashingUtil {

	public static String SHA1(String text) throws Exception {
		return doShaWithType(text, "SHA-1", null);
	}
	
	public static String SHA1(String text, byte[] salt) throws Exception {
		return doShaWithType(text, "SHA-1", salt);
	}

	public static String SHA256(String text) throws Exception {
		return doShaWithType(text, "SHA-256", null);
	}
	
	public static String SHA256(String text, byte[] salt) throws Exception {
		return doShaWithType(text, "SHA-256", salt);
	}
	
	public static String SHA384(String text) throws Exception {
		return doShaWithType(text, "SHA-384", null);
	}
	
	public static String SHA384(String text, byte[] salt) throws Exception {
		return doShaWithType(text, "SHA-384", salt);
	}
	
	public static String SHA512(String text) throws Exception {
		return doShaWithType(text, "SHA-512", null);
	}
	
	public static String SHA512(String text, byte[] salt) throws Exception {
		return doShaWithType(text, "SHA-512", salt);
	}
	
	private static String doShaWithType(String text, String mdInstance, byte[] salt) throws Exception {
		MessageDigest md = MessageDigest.getInstance(mdInstance);
		byte[] shaHash = null;
		
		if(salt == null) {
			md.update(text.getBytes("iso-8859-1"));
			shaHash = md.digest();
		} else {
			md.update(salt);
			shaHash = md.digest(text.getBytes("iso-8859-1"));
		}
		
		return toHex(shaHash);
	}
	
	public static String PBKDF2(String text, int iterations, byte[] salt)
			throws Exception {
		PBEKeySpec spec = new PBEKeySpec(text.toCharArray(), salt, iterations, 64 * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		return toHex(hash);
	}

	public static String toHex(byte[] array) throws Exception {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

}
