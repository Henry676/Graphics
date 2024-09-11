package p1.basicos.poo;

public class Cadena{
	private static String nombre;

	Cadena(String[] nombre){
		Cadena.nombre = nombre[0];
	}

	private static void imprimirSubcadenas(){
		for(int i = 0; i < nombre.length(); i++){
			System.out.println(nombre.substring(0,nombre.length()-i));
		}
		for(int i = nombre.length()-1; i>=0; i--){
			System.out.println(nombre.substring(i));
		}
	}

	public static void main (String[] args){
		new Cadena(args);
		Cadena.imprimirSubcadenas();
		 //Se deja de apuntar al objeto para que posteriormente, actue el garbage collector
	}
}
