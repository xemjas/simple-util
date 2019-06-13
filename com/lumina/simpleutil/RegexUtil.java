package com.lumina.simpleutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xemjas
 *
 */
public class RegexUtil {
	public static boolean checkNumberOnly(String text) {
		return checkRegex("[0-9]{1,}", text); 
	}
	
	public static boolean checkAlphabethUpperCaseOnly(String text) {
		return checkRegex("[A-Z]{1,}", text); 
	}
	
	public static boolean checkAlphabethLowerCaseOnly(String text) {
		return checkRegex("[a-z]{1,}", text); 
	}
	
	public static boolean checkAlphabethCaseInsensitiveOnly(String text) {
		return checkRegex("[A-Za-z]{1,}", text); 
	}
	
	private static boolean checkRegex(String regex, String text) {
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(text);

		return matcher.matches();
	}
}
