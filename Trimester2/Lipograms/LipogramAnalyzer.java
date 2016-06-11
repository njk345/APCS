//Nick Keirstead
import java.util.*;
public class LipogramAnalyzer
{
    private String text;
    private String[] textSplit;
    //textSplit is an array of each separated word in text
    public LipogramAnalyzer(String text) {
        this.text = text; //get input text
        textSplit = cleanse(text).split(" ");
        //remove non letters or spaces from text and split it into an array
    }
    public String mark(char letter) {
        return text.replaceAll("" + letter, "#");
    }
    public String allWordsWith(char letter) {
        //could use arraylist, but the contains() operation is O(n) whereas
        //hashset contains() is O(1) --> will be much faster given long input text
        HashSet<String> offending = new HashSet<String>();
        for (String word : textSplit) {
            if (word.indexOf(letter) != -1 && !offending.contains(word)) {
                offending.add(word);
            }
        }
        String rv = "";
        for (String badWord : offending) {
            rv += (badWord + "\n");
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
}
