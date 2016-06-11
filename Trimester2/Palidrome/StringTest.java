//Nick Keirstead
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;

public class StringTest extends JFrame
        implements ActionListener
{
  private JTextField input, result;

  public StringTest()
  {
    super("String test");
    Box box1 = Box.createVerticalBox();
    box1.add(Box.createVerticalStrut(20));
    box1.add(new JLabel("Input:"));
    box1.add(Box.createVerticalStrut(20));
    box1.add(new JLabel("Result:"));

    input = new JTextField(20);
    input.setBackground(Color.YELLOW);
    input.addActionListener(this);
    input.selectAll();

    result = new JTextField(20);
    result.setBackground(Color.WHITE);
    result.setEditable(false);

    Box box2 = Box.createVerticalBox();
    box1.add(Box.createVerticalStrut(20));
    box2.add(input);
    box2.add(Box.createVerticalStrut(20));
    box2.add(result);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(box1);
    c.add(box2);
    input.requestFocus();
  }

  public void actionPerformed(ActionEvent e)
  {
    String str = input.getText();

    str = isPalImproved(str)? "It's a Palindrome!" : "It's Not a Palindrome";

    result.setText(str);
    input.selectAll();
  }

	public static boolean isPalindrome(String word) {
		//simple version that considers every character,
		//no matter if it's not alphanumeric.
		if (word.length() == 0) return false;
		if (word.length() == 1) return true;
		if (word.length() == 2) return word.charAt(0) == word.charAt(1);
		if (word.charAt(0) != word.charAt(word.length() - 1)) {
			return false;
		}
		return isPalindrome(word.substring(1, word.length() - 1));
	}
	
	public static boolean isPalImproved(String s) {
			//passes in the "cleaned" version of s to the original
			//palindrome method
			s = clean(s);
			return isPalindrome(s);
	}
		
	public static String clean(String s) {
		//returns new string of all alphanumeric chars from s,
		//made to be lowercase
		String rv = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				rv += s.charAt(i);
			}
		}
		return rv.toLowerCase();
	}

  public static void main(String[] args)
  {
    StringTest window = new StringTest();
    window.setBounds(100, 100, 360, 160);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

