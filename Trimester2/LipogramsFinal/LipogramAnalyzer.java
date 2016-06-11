//Nick Keirstead
import java.util.*;
public class LipogramAnalyzer
{
    private String text;
    //textSplit is an array of each separated word in text
    public LipogramAnalyzer(String text) {
        this.text = text; //get input text
        
    }
    public String mark(char letter) {
        return text.replaceAll("" + letter, "#");
    }
    public String allWordsWith(char letter) {
        String rv = "";
        text = cleanse(text);
        int start = 0;
        while (start < text.length()) {
            int end = start;
            while (end < text.length()) {
                if (text.charAt(end) == ' ') {
                    break;
                }
                end++;
            }
            String s = text.substring(start, end);
            if (s.contains("" + letter) && !containsStr(rv, s)) {
                rv += s + "\n";
            }
            start = end + 1;
        }
        return rv;
    }
    private String cleanse(String s) {
        //removes all non letters or spaces from the string
        String rv = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) || c == ' ') {
                rv += s.charAt(i);
            }
        }
        return rv;
    }
    private boolean containsStr(String s, String s2) {
		int start = 0;
		while (start < s.length()) {
			int end = start;
			while (end < s.length()) {
				if (s.charAt(end) == '\n') {
					break;
				}
				end++;
			}
			if (s.substring(start, end).equals(s2)) {
				return true;
			}
			start = end + 1;
		}
		return false;
	}
}
