package p1.mouse;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;;


public class Mouse extends JFrame implements MouseListener, MouseMotionListener{
    private Container contenedor;
    private JLabel et1,et2;

    public Mouse(){
        super("Eventos de mouse");
        contenedor = getContentPane();
        contenedor.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);

        et1 = new JLabel("Probando eventos de raton");
        et1.setBounds(150, 130, 480, 15);
        add(et1);
        
        et2 = new JLabel("");
        et2.setBounds(150,155, 480, 15);
        add(et2);

        setVisible(true);
        setLocationRelativeTo(null);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public static void main(String[] args) {
        new Mouse();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String cadena = "";
        int boton = 0;
        boton = e.getButton();
        if(boton == MouseEvent.BUTTON1) {cadena ="Boton izquierdo";}
        if(boton == MouseEvent.BUTTON2) {cadena ="Boton rueda";}
        if(boton == MouseEvent.BUTTON3) {cadena ="Boton derecho";}

        et2.setText("Diste "+e.getClickCount()+" click con el "+cadena);
        System.out.println("Diste "+e.getClickCount()+" click con el "+cadena);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        /*String cadena = "";
        int valor = 0;
        valor = e.getModifiersEx();
        if(valor == 1024){
            cadena = "Boton izquierdo";
            System.out.println("Apretaste el click derecho");
        }
        if(valor == 2048){
            cadena = "Rueda del mouse";
            System.out.println("Valor de la rueda");
        }
        if(valor == 4096){
            cadena = "Boton derecho";
            System.out.println("Apretaste el click derecho");
        }
        et2.setText("Presionaste el boton "+cadena);
        System.out.println("Presionaste el boton "+cadena);*/
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        /*et2.setText("Dejaste de presionar el boton");
        System.out.println("Soltaste el boton");*/
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        et2.setText("Entraste a la ventana");
        System.out.println("El puntero del mouse entra al JFrame");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        et2.setText("Saliste de la ventana");
        System.out.println("El puntero del mouse salio del JFrame");
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        et2.setText("Cursor en movimiento y apretando el boton");
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        et2.setText("Cursor en movimiento");
    }   
}
