package p1.basicos.poo;

public class Hola{
	private String txt;// Variable de instancia
        Hola(String txt){ // Constructor
                this.txt = txt; // Inicializacion de la variable
        }
        private void saludar(){// Metodo de instancia
                System.out.println(txt);
        }
        public static void main(String[] args){// Metodo de clase (main)
                Hola h = new Hola(args[0]);// Instancia de la clase 
                h.saludar();
		h = null; // Destruccion del objeto
        }
}
