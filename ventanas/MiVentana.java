package p1.ventanas;
import javax.swing.*;

public class MiVentana extends JFrame{

    MiVentana(){
        super("Mi primera ventana");
        setSize(200,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String [] args){
        new MiVentana();
    }    
}
