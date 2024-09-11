package p1.repaso;

public class Calculadora{

	private double sumar(double n1, double n2){
		double r = n1 + n2;
		System.out.println("METODO DOUBLE");
		return r;
	}
	
	private double sumar(int n1, int n2){
		 double r = n1 + n2;
		 System.out.println("METODO INT");
		return r; 
	}
	
	
	private void imprimirResultado(double r){
		System.out.println("La suma es: "+r);	
	}

	public static void main (String [] args){
		
			Calculadora c = new Calculadora();
		try{
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			double resultado = c.sumar(n1,n2);
			c.imprimirResultado(resultado);
		}catch(Exception e ){
			double n1 = Double.parseDouble(args[0]);
			double n2 = Double.parseDouble(args[1]);
			double resultado = c.sumar(n1,n2);
			c.imprimirResultado(resultado);
		}
	}
}
