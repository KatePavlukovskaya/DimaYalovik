package by.bsuir.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean isNumberInString(String text) {
		Pattern p = Pattern.compile("[�-��-�a-zA-Z]+");
		Matcher m = p.matcher(text);
		return m.matches();
	}

}
