package p1.ventanas;

import javax.swing.*;
import java.awt.*;

public class Monito extends JFrame{
    

    Monito(){
        super("Monito");
        setSize(600,700);
        setVisible(true);
        setLocationRelativeTo(null);//Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        g.drawString("Demo de graficos", 270, 50);
        //Dibujar carita
        g.drawArc(270, 170, 100, 100, 0, 360); //distancia en x, altura en y, ancho de la figura, altura de la figura, 
        g.drawArc(295, 220, 50, 30, 180, 180); //boca
        g.drawLine(295, 235, 345, 235);//parte de la boca

        //angulo inicial y angulo de arco (circulo completo en este caso)
        //Llenado de ovalo
        g.fillOval(300, 205, 5, 5);//Un ojo
        g.fillOval(335, 205, 5, 5);//Otro ojo

        g.drawLine(320, 270, 320, 500);//Cuerpo
        g.drawLine(320, 500, 400, 580);//Pierna
        g.drawLine(320, 500, 240, 580);//Otra Pierna
        //Brazos
        g.drawLine(320, 350, 400, 330);
        g.drawLine(320, 350, 240, 330);
        //Sombrero
        //g.setColor(Color.black);
        //g.drawRect(245, 170, 150, 5);
        g.fillRect(245, 180, 150, 5);
        g.fillRect(275, 150, 90, 30);


    }
    public static void main(String[] args) {
        new Monito();
    }
}
