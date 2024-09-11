package p1.ventanas;

import javax.swing.*;
import java.awt.*;

public class Espiral extends JFrame implements Runnable{
    private Thread hilo;
    private int ancho = 10, anguloInicial2 = 360, anguloArco2 = -180,
    altura = 10,anguloInicial1 = -180, anguloArco1 = -180, x1=300,y1 = 300,x2 = 305,y2 = 300;
    private byte intento = 0;
    Espiral(){
        super("Espiral de Arquimedes");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        hilo = new Thread(this);
        hilo.start();
    }
    public void paint(Graphics g){
        System.out.println("INICIALES");
        System.out.println("INTENTO INICIO "+intento);

        g.drawArc(x1, y1, ancho, altura, anguloInicial1, anguloArco1);

        System.out.println(x1 +", "+ y1 +", "+ ancho +", " +altura +", "+ anguloInicial1 +", "+ anguloArco1);
        g.drawArc(x2, y2, ancho, altura, anguloInicial2, anguloArco2);
        /*g.drawLine(300, 0, 300, 600);
        g.drawLine(0, 305, 600, 305);*/
        System.out.println(x2 +", "+ y2 +", "+ ancho +", " +altura +", "+ anguloInicial2 +", "+ anguloArco2);

        if(intento > 0){
            update(g);
        } else {
            ++intento;
        }
    }
    public void update(Graphics g){
        if(intento >= 1){
            if(intento % 2 == 0 || intento == 0) x1 -=10;
            y1-=5;
            ancho +=10;
            altura = ancho;
            anguloArco1 = anguloArco1 * -1;

            if(intento % 2 != 0 || intento == 1) x2 -= 10;
            y2-=5;
            anguloArco2 = anguloArco2 * -1;
            ++intento;
        }
        
    }

    public void run(){
        while(true){
            try{
                Thread.sleep(125);
                System.out.println("LLAMANDO REPAINT");
                if(intento>0) repaint();
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
        }
    }
    public static void main(String[] args) {
        new Espiral();
    }
}
