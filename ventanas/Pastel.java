package p1.ventanas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pastel extends JFrame implements FocusListener, ActionListener{
  
    private JLabel [] teams = new JLabel[4];
    private JTextField [] txtFields = new JTextField[4];
    private double [] porcentaje = new double[4];
    private  int y = 400,total = 0;
    private JButton showGraphic;
    private boolean flag = false;

    public Pastel() {
        super("Grafica de pastel");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        showGraphic = new JButton("Mostrar grafica");
        showGraphic.setBounds(225,370,150,20);
        add(showGraphic);
        showGraphic.addActionListener(this);
        getContentPane().setBackground(Color.black);

        for(byte i = 0; i<teams.length;i++){
            txtFields[i] = new JTextField("Ingrese la cantidad de personas");
            teams[i] = new JLabel();
            teams[i].setForeground(Color.white);
            switch(i){
                case 0: teams[i].setText("Personas que le van a Chivas"); break;
                case 1: teams[i].setText("Personas que le van al America"); break;
                case 2: teams[i].setText("Personas que le van al Cruz Azul"); break;
                case 3: teams[i].setText("Personas que le van al Pumas"); break;
            }
            
            teams[i].setBounds(20, y, 400, 15);
            add(teams[i]);
            txtFields[i].setBounds(300, y, 250, 20);
            add(txtFields[i]);
            txtFields[i].addFocusListener(this);
            y+=40;

        }

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if(flag == true){
            int [] values = new int[4];
            for(byte i = 0; i<values.length; i++){
                values[i] = Integer.parseInt(txtFields[i].getText());
                total = total + values[i];
            }
            System.out.println(total);
            int [] grados = new int[4];
            for(byte i = 0; i<values.length; i++){
                grados[i] = values[i] * 360/total;
                porcentaje[i] = (double)(values[i] * 100) / total;
            }
            System.out.println(grados[3]);
            g.setColor(Color.red);
            g.drawString("Chivas", 80, 135);
            g.drawString(String.valueOf(porcentaje[0]) + " %", 160, 135); 
            g.fillRect(20, 120, 20, 20);
            g.fillArc(325, 160, 200, 200, 0, grados[0]);
                
            g.setColor(Color.yellow); 
            g.drawString("America", 80, 165);
            g.drawString(String.valueOf(porcentaje[1] + " %"), 160, 165);
            g.fillRect(20, 150, 20, 20); 
            g.fillArc(325, 160, 200, 200, grados[0], grados[1]);

            g.setColor(Color.blue);
            g.drawString("Cruz azul", 80, 195); 
            g.drawString(String.valueOf(porcentaje[2]) + " %", 160, 195);
            g.fillRect(20, 180, 20, 20);
            g.fillArc(325, 160, 200, 200, grados[0] + grados[1], grados[2]);

            g.setColor(Color.ORANGE); 
            g.drawString("Pumas", 80, 225); 
            g.drawString(String.valueOf(porcentaje[3] + " %"), 160, 225);
            g.fillRect(20, 210, 20, 20);
            g.fillArc(325, 160, 200, 200, grados[0] + grados[1] + grados[2], 360 - (grados[0] + grados[1] + grados[2]));
            g.drawString("Total de personas: ", 20, 255);
            g.drawString(String.valueOf(total), 160, 255);

            for(byte i = 0; i<txtFields.length; i++){
                txtFields[i].setText("");
                values[i] = 0;
                grados[i] = 0;
                total = 0;
                flag = false;
            }
        }
    }


    @Override
    public void focusGained(FocusEvent e) {
        JTextField field = (JTextField) e.getSource();
        if(field.getText().equals("Ingrese la cantidad de personas")){
            field.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField field = (JTextField) e.getSource();
        if(field.getText().isEmpty()){
            field.setText("Ingrese la cantidad de personas");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        byte validate = 0;
        for(byte i = 0; i<txtFields.length;i++){
            if(txtFields[i].getText().equals("Ingrese la cantidad de personas")){
                System.out.println("El campo "+(i+1)+" esta vacio");
            } else {
                validate+=1;
            }
        }
        if(validate == 4){
            flag = true;
            repaint();
        }
    }

    public static void main(String[] args) {
        new Pastel();
    }

}
