package p1.basicos.poo;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Convertidor {
    private String dato;

    Convertidor(String dato) {
        this.dato = dato;
    }
    private boolean validarIp(){
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern patron = Pattern.compile(regex);
        Matcher m = patron.matcher(dato);
        return m.matches();
    }
    private boolean validarHex(){
        String regex = "^[0-9a-fA-F]{8}$";
        //String regex = "^([0-9]|[A-F]|[a-f])$";
        //String regex = "^A[0-9]|B[0-9]|C[0-9]|D[0-9]|E[0-9]|F[0-9]|[0-9]A|[0-9]B|[0-9]C|[0-9]D|[0-9]E|[0-9]F|A[A-F]|B[A-F]|C[A-F]|D[A-F]|E[A-F]|F[A-F]|[A-F]A|[A-F]B|[A-F]C|[A-F]D|[A-F]E|[A-F]F{2}{4}$";
        Pattern patron = Pattern.compile(regex);
        Matcher m = patron.matcher(dato);
        return m.matches();
    }

    private String convertiraHex() {
       StringBuilder resultado = new StringBuilder();//Usé stringbuilder para ir agregando el resultado de cada octeto, es la ventaja de que es mutable (se puede modificar)
	   String [] octetos = dato.split("\\.");//Va a dividir la ip en subcadenas con el punto "." como delimitante y guardar cada division en cada posicion del array
	   
       for (String octeto : octetos) {//Iterando con for each, toda variable de tipo String es inmutable (no se puede modificar como agregar)
			int valorOcteto = Integer.parseInt(octeto);//For each: indice,array
			String hex = Integer.toHexString(valorOcteto).toUpperCase();//Aqui convierte el octeto en hexadecimal y vuelve mayuscula la letra A-F
			if(hex.length()<2){//Esto es para asegurar que cada octeto en hexadecimal tenga 2 digitos.
                resultado.append(0);
            }
            resultado.append(hex);
	   }
	   return resultado.toString();
    }

    private String convertiraIP() {
        StringBuilder resultado = new StringBuilder();//Usé stringbuilder para ir agregando el resultado de cada octeto, es la ventaja de que es mutable (se puede modificar)

        for(byte i = 0; i<dato.length();i+=2){
            String par = dato.substring(i, i+2);
            int octeto = Integer.parseInt(par,16); //base 16 de hexadecimal
            resultado.append(octeto).append(".");
        }
        if(resultado.length()>0){resultado.setLength(resultado.length()-1);}
        
        return resultado.toString();
     }


    private void imprimir(String resultado) {
			System.out.println("Conversion: "+resultado);
    }

    public static void main(String[] args) {
        if (args[0].equals("-ip")) {
            Convertidor c = new Convertidor(args[1]);
            if(c.validarIp()){
                String resultado = c.convertiraHex();
                c.imprimir(resultado);
                c = null;
            } else {
                System.out.println("Ip invalida, error");
            }
        } else if (args[0].equals("-hex")){
            Convertidor c = new Convertidor(args[1]);
            if(c.validarHex()){
                String resultado = c.convertiraIP();
                c.imprimir(resultado);
                c = null;
            } else {
                System.out.println("Valor hexadecimal invalida, error");
            }
        } else {
            System.out.println("Error");
        }
    }
}