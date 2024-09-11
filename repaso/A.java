public class A{
	/*public int inc(int j){
		++j;
		return j;
	}
	public static void main (String [] args){
		A a = new A();
		int j = 10, i;
		i = a.inc(j);
		System.out.println("Valor de i: "+i);
		System.out.println("Valor de j: "+j);
	}*/
	int b;
	A(){
	b=12;
	}
	A(int hour){
		this.b = hour;
	}
	public static void main(String [] args){
		A a = new A();
		A b = new A(13);
		a = b;
		System.out.println(a.b);
	}
}

