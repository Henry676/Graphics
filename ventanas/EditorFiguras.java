package p1.ventanas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class EditorFiguras extends JFrame implements 
ActionListener,MouseListener,MouseMotionListener{

    private ButtonGroup modos;
    private JPanel area;
    private JLabel status;
    private Image buffer;
    private Image buffTemporal;
    
    private final int PUNTOS = 1;
    private final int LINEAS = 2;
    private final int RECTANGULOS = 3;
    private final int CIRCULOS = 4;
    private int modo;
    private int x, y;

    public EditorFiguras(){
        super("Editor de figuras");
        //Menu archivo
        JMenu menuArchivo = new JMenu("Archivo");

        //Opcion nuevo
        JMenuItem opcionNuevo = new JMenuItem("Nuevo",'N');
        opcionNuevo.addActionListener(this);
        opcionNuevo.setActionCommand("Nuevo");
        menuArchivo.add(opcionNuevo);

        menuArchivo.addSeparator();
        //Opcion Salir
        JMenuItem opcionSalir = new JMenuItem("Salir",'S');
        opcionSalir.addActionListener(this);
        opcionSalir.setActionCommand("Salir");
        menuArchivo.add(opcionSalir);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuArchivo);

        modos = new ButtonGroup();
        //Menu modo
        JMenu menuModo = new JMenu("Modo");
        //Opcion Puntos
        JRadioButtonMenuItem opcionPuntos = new JRadioButtonMenuItem("Puntos",true);

        opcionPuntos.addActionListener(this);
        opcionPuntos.setActionCommand("Puntos");
        menuModo.add(opcionPuntos);
        modos.add(opcionPuntos);
        //Opcion Lineas
        JRadioButtonMenuItem opcionLineas = new JRadioButtonMenuItem("Lineas");
        opcionLineas.addActionListener(this);
        opcionLineas.setActionCommand("Lineas");
        menuModo.add(opcionLineas);
        modos.add(opcionLineas);
        //Opcion Rectangulos-----------------------------
        JRadioButtonMenuItem opcionRectangulos = new JRadioButtonMenuItem("Rectangulos");
        opcionRectangulos.addActionListener(this);
        opcionRectangulos.setActionCommand("Rectangulos");
        menuModo.add(opcionRectangulos);
        modos.add(opcionRectangulos);
        //Opcion Circulos
        JRadioButtonMenuItem opcionCirculos = new JRadioButtonMenuItem("Circulos");
        opcionCirculos.addActionListener(this);
        opcionCirculos.setActionCommand("Circulos");
        menuModo.add(opcionCirculos);
        modos.add(opcionCirculos);
        menuBar.add(menuModo);


        area = new JPanel();
        area.addMouseListener(this);
        area.addMouseMotionListener(this);
        status = new JLabel("Status",JLabel.LEFT);
        //Asignar barra menues
        setJMenuBar(menuBar);
        //Agregar zona grafica
        getContentPane().add(area, BorderLayout.CENTER);
        //Agregar barra de estado
        getContentPane().add(status, BorderLayout.SOUTH);
        modo = PUNTOS;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
        buffer = area.createImage(area.getWidth(), area.getHeight());
        setLocationRelativeTo(null);
    }   


    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = buffTemporal.getGraphics();
        switch(modo){
            case PUNTOS:
                System.out.println("DIBUJANDO PUNTOS");
                g.fillOval(e.getX(), e.getY(), 10, 10);
                area.getGraphics().drawImage(buffTemporal, 0, 0, this);
                break;
            case LINEAS:
            System.out.println("DIBUJANDO LINEAS");
                g.drawImage(buffer, 0, 0, this);
                g.drawLine(x, y, e.getX(), e.getY());
                area.getGraphics().drawImage(buffTemporal, 0, 0, this);
                break;
            case RECTANGULOS:
            System.out.println("DIBUJANDO RECTANGULOS");
                g.drawImage(buffer, 0, 0, this);
                g.drawRect(x, y, e.getX()-x, e.getY()-y);
                area.getGraphics().drawImage(buffTemporal, 0,0, this);
                break;
            case CIRCULOS:
            System.out.println("DIBUJANDO CIRCULOS");
                g.drawImage(buffer, 0, 0, this);
                g.drawOval(x, y, e.getX()-x, e.getY()-y);
                area.getGraphics().drawImage(buffTemporal, 0, 0, this);
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        status.setText("x="+e.getX() + ",y=" + e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        
        buffTemporal = area.createImage(area.getWidth(),area.getHeight());
        buffTemporal.getGraphics().drawImage(buffer, 0, 0, this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buffer.getGraphics().drawImage(buffTemporal, 0, 0, this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getDefaultCursor());
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("Nuevo")){
            buffTemporal = null;
            buffer = null;
            buffer = area.createImage(area.getWidth(), area.getHeight());
            //buffTemporal = area.createImage(area.getWidth(), area.getHeight());

            area.getGraphics().clearRect(0, 0, area.getWidth(), area.getHeight());
        }else
        if(comando.equals("Salir")){
            if(JOptionPane.showConfirmDialog(this, "¿En verdad desea salir", "Confirmacion", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                dispose();
                System.exit(0);
            }
        } else
        if(comando.equals("Puntos")){
            modo = PUNTOS;
        }else
        if(comando.equals("Lineas")){
            modo = LINEAS;
        } else 
        if(comando.equals("Circulos")){
            modo = CIRCULOS;
        } else 
        if(comando.equals("Rectangulos")){
            modo = RECTANGULOS;
        }
    }
    public static void main(String[] args) {
        new EditorFiguras();
    }
}
