package p1.componentes;

import java.awt.*;
import javax.swing.*;

public class Pantalla extends JPanel{
    private Image imagen;

    public Pantalla(Image imagen){
        this.imagen = imagen;   
    }
    public void paint(Graphics g){
        super.paint(g); //Desplegar para obtener dimensiones reales en pantalla 
        Dimension tam = new Dimension(imagen.getWidth(this),
        imagen.getHeight(this));
        setPreferredSize(tam);
        setMinimumSize(tam);
        setSize(tam);
        update(g);
    }
    public void update(Graphics g){
        g.drawImage(imagen, 0, 0, this);
    }
}
