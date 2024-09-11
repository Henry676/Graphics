package p1.componentes;

import javax.swing.*;
import java.awt.*;

public class VisorImagenes extends JFrame{

    private JScrollPane panel;
    private Pantalla pantalla;

    public VisorImagenes(String archivo){
        super("Visor de imagen");
        
        Image img = Toolkit.getDefaultToolkit().getImage(archivo);
        pantalla = new Pantalla(img);
        panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        getContentPane().add(panel);
        panel.setViewportView(pantalla);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public static void main(String[] args) {
        new VisorImagenes("/home/hertz676/Documentos/graficas/p1/componentes/avatar.jpg");
    }
}
