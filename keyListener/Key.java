package p1.keyListener;

import java.awt.event.*;
import javax.swing.*;

public class Key extends JFrame implements KeyListener{
    private JLabel nombreTecla, codigoTecla;
    public Key(){
        setTitle("Eventos de teclado");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        nombreTecla = new JLabel("Presione una tecla");
        nombreTecla.setBounds(100,150,300,150);
        add(nombreTecla);

        codigoTecla = new JLabel("");
        codigoTecla.setBounds(100,185,300,150);
        add(codigoTecla);

        addKeyListener(this);
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*char caracter = e.getKeyChar();
        nombreTecla.setText("Ha tecleado el caracter: "+Character.toString(caracter));
        codigoTecla.setText("El metodo getKeyChar regresa 0 ");*/
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        char caracter = e.getKeyChar();

        nombreTecla.setText("Ha presionado el caracter: "+Character.toString(caracter));
        codigoTecla.setText("Codigo del caracter: "+codigo);

        System.out.println(Character.toString(caracter));
        System.out.println(codigo);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int codigo = e.getKeyCode();
        char caracter = e.getKeyChar();
        nombreTecla.setText("Ha soltado el caracter: "+Character.toString(caracter));
        codigoTecla.setText("Codigo del caracter: "+codigo);

        System.out.println(Character.toString(caracter));
        System.out.println(codigo);
    }

    public static void main(String[] args) {
        new Key();
    }
}
