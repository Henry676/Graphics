package p1.basicos.calculator;

public class AlgoritmoCalculadora{


    protected double sumar(double n1, double n2){
		System.out.println("SUMA DOUBLE");
		return n1+n2;
	}
	
	protected double sumar(int n1, int n2){
		System.out.println("SUMA INT");
		return n1+n2; 
	}

	protected double restar(double n1, double n2){
		System.out.println("RESTA DOUBLE");
		return n1-n2;
	}
	
	protected double restar(int n1, int n2 ){
		System.out.println("RESTA INT");
		return n1-n2; 
	}
	protected double multiplicar(double n1, double n2){
		System.out.println("MULTI DOUBLE");
		return n1*n2;
	}
	
	protected double multiplicar(int n1, int n2 ){
		System.out.println("MULTI INT");
		return n1*n2; 
	}
	protected double dividir(double n1, double n2){
		System.out.println("DIV DOUBLE");
		if(n2 == 0){
			return -1.0;
		}
		return ((double)n1/n2);
	}
	
	protected double dividir(int n1, int n2 ){
		System.out.println("DIV INT");
		if(n2 == 0){
			return -1;
		}
		return ((double)n1/n2); 
	}
}