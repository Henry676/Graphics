package p1.basicos.poo;

import java.util.Arrays;
class Lista{
	private static int [] numeros = new int[10];//variable de clase
//-----------------Metodos de instancia
	private void guardarNumeros(String [] args){
		for(byte i = 0; i<args.length; i++){
			numeros[i] = Integer.parseInt(args[i]);
		}
	}
	private void ordenarNumeros(){
      		Arrays.sort(numeros);
	}
	private void imprimirNumeros(){
		for(byte i = 0; i<numeros.length; i++){
			System.out.print(numeros[i] + " ");
		}
       	}
//------------------Fin de metodos
    public static void main(String [] args) {
	    Lista l = new Lista();
	    l.guardarNumeros(args);
	    System.out.println("Numeros ingresados: ");	    
	    l.imprimirNumeros();
	    System.out.println("\nNumeros ordenados de menor a mayor: ");
	    l.ordenarNumeros();
	    l.imprimirNumeros();
	    l = null;
    }
}
