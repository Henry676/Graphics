package p1.repaso;

import java.awt.*;
import javax.swing.*;

public class Grid extends JFrame{
    public Grid(){
        super("GRID");
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*JButton btn1 = new JButton("Btn 1");
        JButton btn2 = new JButton("Btn 2");
        JButton btn3 = new JButton("Btn 3");
        JButton btn4 = new JButton("Btn 4");
        JButton btn5 = new JButton("Btn 5");
        JButton btn6 = new JButton("Btn 6");
        JButton btn7 = new JButton("Btn 7");
        JButton btn8 = new JButton("Btn 8");
        JButton btn9 = new JButton("Btn 9");

        GridBagLayout gbl = new GridBagLayout();
        getContentPane().setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;*/


    }
    public static void main(String[] args) {
        new Grid();
    }
}
