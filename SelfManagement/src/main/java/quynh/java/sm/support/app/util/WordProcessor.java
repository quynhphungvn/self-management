package quynh.java.sm.support.app.util;

public class WordProcessor {
	
	public static String removeUnexpectedChar(String s) {
		return s.trim()
				.toLowerCase()
				.replace(".", "")
				.replace("-", "")
				.replace(",", "")
				.replace("\\", "")
				.replace("!", "")
				.replace("~", "")
				.replace("'?", "")
				.replace("?", "")
				.replace(":", "")
				.replace(";", "")
				.replace("\"", "")
				.replace("(", "")
				.replace(")", "")
				.replace("[", "")
				.replace("]", "")
				.replace("'ll", "")
				.replace("'d", "")
				.replace("'ve", "")
				.replace("'re", "")
				.replace("'m", "")
				.replace("'s", "");
	}
}