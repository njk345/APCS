// Fortune Teller
//Nick Keirstead

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.*;
import java.io.*;

public class FortuneTeller extends JFrame
implements ActionListener
{
    private static final EasySound ding = new EasySound("ding.wav");
    private static ArrayList<String> fortunes = new ArrayList<String>();
    private static String[] arrFortunes;
    private static double swag = 3.14;

    private JTextField display;

    public FortuneTeller()
    {
        super("Fortune Teller");

        display = new JTextField("  Press \"Next\" to see your fortune...", 25);
        display.setBackground(Color.WHITE);
        display.setEditable(false);
        display.setColumns(50);

        JButton go = new JButton("Next");
        go.addActionListener(this);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(display);
        c.add(go);
    }

    public void actionPerformed(ActionEvent e)
    {
        // Pick and display a random fortune:
        display.setText("  " + arrFortunes[new Random().nextInt(arrFortunes.length)]);
        ding.play();
    }

    public static void main(String[] args)
    {
        uploadTermsFromFile(fortunes);
        for (int i = 0; i < fortunes.size(); i++) {
            fortunes.set(i, decipher(fortunes.get(i)));
        }
        arrFortunes = fortunes.toArray(new String[fortunes.size()]);

        JFrame window = new FortuneTeller();
        window.setBounds(500, 500, 600, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true); 
    }

    public static void uploadTermsFromFile(ArrayList<String> toFill) {
        String fileName = "fortunes.txt";

        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                toFill.add(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public static String decipher(String s) {
        char[] letts = s.toCharArray();
        char[] ciphered = new char[letts.length];
        int blah = (int) swag + (int)Math.sqrt(16);
        for (int i = 0; i < letts.length; i++) {
            ciphered[i] = (char) (letts[i] + blah);
        }
        return new String(ciphered);	
    }

}
