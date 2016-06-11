//Nick Keirstead
//Dog Age to Human Age Lab

import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.text.DecimalFormat;

public class DogAge extends JFrame
  implements ActionListener
{
  JTextField dogAgeField, humanAgeField;

  public DogAge()
  {
    super("Dog To Human Age Convertor");
    JLabel dogAgeLabel = new JLabel("Dog Age (years): ", SwingConstants.RIGHT);
    dogAgeField = new JTextField(5);
    
	JLabel humanAgeLabel = new JLabel("Human Age (years):", SwingConstants.RIGHT);
    humanAgeField = new JTextField(5);
	humanAgeField.setEditable(false);

    JButton go = new JButton("Convert");
    go.addActionListener(this);

    Container c = getContentPane();
    c.setBackground(Color.white);
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(3, 2, 5, 5));
    p.add(dogAgeField);
    p.add(dogAgeLabel);
    p.add(humanAgeField);
    p.add(humanAgeLabel);
    c.add(p, BorderLayout.CENTER);
    c.add(go, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e)
  {
    int dogAge = Integer.parseInt(dogAgeField.getText());
    int humanAge = convertToHumanAge(dogAge);
    humanAgeField.setText("" + humanAge);
  }

  public int convertToHumanAge(int dogAge)
  {
	if (dogAge < 1) return 0;
	return 13 + Math.round((float) (dogAge - 1) / 3 * 16);
  }

  public static void main(String[] args)
  {
    DogAge d = new DogAge();
    d.setBounds(300, 300, 300, 160);
    d.setDefaultCloseOperation(EXIT_ON_CLOSE);
    d.setVisible(true);
  }
}

