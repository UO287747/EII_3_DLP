package parser;

import java.io.CharConversionException;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		try {
			if (str.charAt(1) == '\\'){
				if (str.charAt(2) == 'n') {
					return '\n';
				} else if (str.charAt(2) == 't') {
					return '\t';
				} else {
					return (char) Integer.parseInt(str.substring(2, str.length() - 1));
				}
			} else {
				return str.charAt(1);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return str.charAt(1);
	}
}
