package p1.basicos.calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculadoraChida extends JFrame implements ActionListener{
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private Container contenedor;
    private JButton [] botones = new JButton[17];
    private AlgoritmoCalculadora c;
    private double resultado = 0;
    private String n1,n2,signo;
    private JTextField pantalla = new JTextField();

    public CalculadoraChida(){
            super("Calculadora");
            contenedor = getContentPane();
            setSize(365,460);
            setLocationRelativeTo(null);
            setResizable(false);
            setIconImage(new ImageIcon(getClass().getResource("calculadora.png")).getImage());//ICONO
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            contenedor.setBackground(Color.BLACK);

            Font fuentePantalla = new Font("Arial",Font.PLAIN,32);//Fuente y tamaño de la letra
            Font decimal = new Font("Arial",Font.BOLD,20);

            pantalla.setHorizontalAlignment(SwingConstants.RIGHT);//Sentido del texto
            pantalla.setFont(fuentePantalla);
            pantalla.setBackground(new Color(64,64,64));
            pantalla.setEditable(false);
            pantalla.setForeground(Color.cyan);

            for(byte i = 0; i < 17; i++){
                    if(i < 10){ JButton btn = new JButton(""+i); botones[i] = btn; botones[i].addActionListener(this);}
                    if(i == 10){ JButton btn = new JButton("."); botones[i] = btn; botones[i].addActionListener(this);}
                    if(i == 11){ JButton btn = new JButton("+"); botones[i] = btn; botones[i].addActionListener(this);}
                    if(i == 12){ JButton btn = new JButton("-"); botones[i] = btn; botones[i].addActionListener(this);}
                    if(i == 13){ JButton btn = new JButton("x"); botones[i] = btn; botones[i].addActionListener(this);}
                    if(i == 14){ JButton btn = new JButton("/"); botones[i] = btn; botones[i].addActionListener(this);}
                    if(i == 15){ JButton btn = new JButton("CE"); botones[i] = btn; botones[i].addActionListener(this);}
                    if(i == 16){ JButton btn = new JButton("="); botones[i] = btn; botones[i].addActionListener(this);}
            }
            //-------------------Personalizacion---------------------
            for(byte i = 0; i<17; i++){
                botones[i].setFont(decimal);
                botones[i].setForeground(Color.red);
                botones[i].setBackground(Color.ORANGE);
                if(i>10 && i < 15){
                    botones[i].setFont(decimal);
                    botones[i].setForeground(Color.red);
                    botones[i].setBackground(Color.yellow);
                }
                if(i>=15 && i <= 16){
                    botones[i].setFont(decimal);
                    botones[i].setForeground(Color.WHITE);
                    botones[i].setBackground(Color.red);
                }
            }

            gbl = new GridBagLayout();
            contenedor.setLayout(gbl);

            gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(5,5,5,5);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 5;
            gbc.gridheight = 2;
            add(pantalla,gbc); 

            //------Botones--------//
            JButton [] btnPosc = {botones[7],botones[8],botones[9],botones[14],botones[15],botones[4],botones[5],botones[6],botones[13],botones[1],botones[2],botones[3],botones[12],botones[16],botones[0],botones[10],botones[11]};
            int index = 0;
            for(byte i = 2; i < 5; i++){//Agregar en y (filas)
                for(byte j = 0; j < 5; j++){//Agregar en x (columnas)
                    if(index !=4 && index != 13){//botones
                        gbc.gridx = j;
                        gbc.gridy = i;
                        gbc.gridwidth = 1;
                        gbc.gridheight = 1;
                        add(btnPosc[index],gbc);
                        if(index == 9 && j == 4){//Boton 1
                            gbc.gridx = j-=j;
                            gbc.gridy = ++i;
                            gbc.gridwidth = 1;
                            gbc.gridheight = 1;
                            add(btnPosc[index],gbc);
                        }
                        ++index;
                    }else if(index == 4 && i == 2){//Boton CE
                        gbc.gridx = j;
                        gbc.gridy = i;
                        gbc.gridwidth = 1;
                        gbc.gridheight = 2;
                        add(btnPosc[index],gbc);
                        ++index;
                    } else if(index == 13 && i == 4){//Boton igual
                        gbc.gridx = j;
                        gbc.gridy = i;
                        gbc.gridwidth = 1;
                        gbc.gridheight = 2;
                        add(btnPosc[index],gbc);
                        ++index;
                    }
                }
                if(index == 14){    //Boton 0      
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    gbc.gridwidth = 2;
                    gbc.gridheight = 1;
                    add(botones[0],gbc);
                }
            }

            index = 10;
            for(byte i = 2; i <= 3; i++){
                gbc.gridx = i;
                gbc.gridy = 5;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                add(botones[index],gbc);
                ++index;
            }
            botones = btnPosc;
            setVisible(true);
    }//Fin constructor--------------------

    public void actionPerformed(ActionEvent operacion){
        for(byte i = 0; i < botones.length; i++){

            if(operacion.getSource() == botones[i] && !botones[i].getText().equals("+") 
            && !botones[i].getText().equals("-") && !botones[i].getText().equals("x") && 
            !botones[i].getText().equals("/") 
            && !botones[i].getText().equals("=")){
                pantalla.setText(pantalla.getText() + botones[i].getText());
            }

            if(operacion.getSource() == botones[i] && botones[i].getText().equals("CE")){
                pantalla.setText("");
            }
    
            if(operacion.getSource() == botones[i] && botones[i].getText().equals(".")){
                pantalla.setText(pantalla.getText());
            }
    
            if(operacion.getSource() == botones[i] && botones[i].getText().equals("+")){
                    StringBuilder cadenaPantalla = new StringBuilder();
                    System.out.println(pantalla.getText());
                    cadenaPantalla.append(pantalla.getText());
                    n1 = cadenaPantalla.toString();
                    signo = botones[i].getText();
                    pantalla.setText("");
            }
            if(operacion.getSource() == botones[i] && botones[i].getText().equals("-")){
                StringBuilder cadenaPantalla = new StringBuilder();
                System.out.println(pantalla.getText());
                cadenaPantalla.append(pantalla.getText());
                n1 = cadenaPantalla.toString();
                signo = botones[i].getText();
                pantalla.setText("");
            }
            if(operacion.getSource() == botones[i] && botones[i].getText().equals("x")){
                StringBuilder cadenaPantalla = new StringBuilder();
                System.out.println(pantalla.getText());
                cadenaPantalla.append(pantalla.getText());
                n1 = cadenaPantalla.toString();
                signo = botones[i].getText();
                pantalla.setText("");
            }
            if(operacion.getSource() == botones[i] && botones[i].getText().equals("/")){
                StringBuilder cadenaPantalla = new StringBuilder();
                System.out.println(pantalla.getText());
                cadenaPantalla.append(pantalla.getText());
                n1 = cadenaPantalla.toString();
                signo = botones[i].getText();
                pantalla.setText("");
            }
            
            if(operacion.getSource() == botones[i] && botones[i].getText().equals("=")){
                switch (signo) {
                    case "+":
                    try {
                        int valor1 = 0,valor2 = 0;
                        StringBuilder cadenaPantalla = new StringBuilder();
                        cadenaPantalla.append(pantalla.getText());
                        n2 = cadenaPantalla.toString();
                        c = new AlgoritmoCalculadora();
                        valor1 = Integer.parseInt(n1);
                        valor2 = Integer.parseInt(n2);
                        resultado = c.sumar(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado % 1 == 0){
                            String [] result = Double.toString(resultado).split("\\.");
                            pantalla.setText(result[0]);
                        }
                        c=null;
                    } catch (Exception e) {
                        double valor1 = 0.0,valor2 = 0.0;
                        valor1 = Double.parseDouble(n1);
                        valor2 = Double.parseDouble(n2);
                        resultado = c.sumar(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado % 1 == 0){
                            String [] result = Double.toString(resultado).split("\\.");
                            pantalla.setText(result[0]);
                        } else {
                            pantalla.setText(Double.toString(resultado));
                        }
                        c=null;
                    }
                        break;
                    case "-":
                    try {
                        int valor1 = 0,valor2 = 0;
                        StringBuilder cadenaPantalla = new StringBuilder();
                        cadenaPantalla.append(pantalla.getText());
                        n2 = cadenaPantalla.toString();
                        c = new AlgoritmoCalculadora();
                        valor1 = Integer.parseInt(n1);
                        valor2 = Integer.parseInt(n2);
                        resultado = c.restar(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado % 1 == 0){
                            String [] result = Double.toString(resultado).split("\\.");
                            pantalla.setText(result[0]);
                        }
                        c=null;
                    } catch (Exception e) {
                        double valor1 = 0.0,valor2 = 0.0;
                        valor1 = Double.parseDouble(n1);
                        valor2 = Double.parseDouble(n2);
                        resultado = c.restar(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado % 1 == 0){
                            String [] result = Double.toString(resultado).split("\\.");
                            pantalla.setText(result[0]);
                        } else {
                            pantalla.setText(Double.toString(resultado));
                        }
                        c=null;
                    }
                        break;
                    case "/":
                    try {
                        int valor1 = 0,valor2 = 0;
                        StringBuilder cadenaPantalla = new StringBuilder();
                        cadenaPantalla.append(pantalla.getText());
                        n2 = cadenaPantalla.toString();
                        c = new AlgoritmoCalculadora();
                        valor1 = Integer.parseInt(n1);
                        valor2 = Integer.parseInt(n2);
                        resultado = c.dividir(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado == -1){
                            pantalla.setText("Error");
                        } else {
                            if(resultado % 1 == 0){
                                String [] result = Double.toString(resultado).split("\\.");
                                pantalla.setText(result[0]);
                            } else {
                                pantalla.setText(Double.toString(resultado));
                            }
                        }
                        c=null;
                    } catch (Exception e) {
                        double valor1 = 0.0,valor2 = 0.0;
                        valor1 = Double.parseDouble(n1);
                        valor2 = Double.parseDouble(n2);
                        resultado = c.dividir(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado == -1.0){
                            pantalla.setText("Error");
                        } else {
                            pantalla.setText(Double.toString(resultado));
                        }
                        c=null;
                    }
                        break;
                    case "x":
                    try {
                        int valor1 = 0,valor2 = 0;
                        StringBuilder cadenaPantalla = new StringBuilder();
                        cadenaPantalla.append(pantalla.getText());
                        n2 = cadenaPantalla.toString();
                        c = new AlgoritmoCalculadora();
                        valor1 = Integer.parseInt(n1);
                        valor2 = Integer.parseInt(n2);
                        resultado = c.multiplicar(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado % 1 == 0){
                            String [] result = Double.toString(resultado).split("\\.");
                            pantalla.setText(result[0]);
                        }
                        c=null;
                    } catch (Exception e) {
                        double valor1 = 0.0,valor2 = 0.0;
                        valor1 = Double.parseDouble(n1);
                        valor2 = Double.parseDouble(n2);
                        resultado = c.multiplicar(valor1, valor2);
                        System.out.println(Double.toString(resultado));
                        if(resultado % 1 == 0){
                            String [] result = Double.toString(resultado).split("\\.");
                            pantalla.setText(result[0]);
                        } else {
                            pantalla.setText(Double.toString(resultado));
                        }
                        c=null;
                    }
                        break;
                    default:
                        break;
                }  
            }
        }
    }
    public static void main(String[] args) {
        new CalculadoraChida();
    }
}