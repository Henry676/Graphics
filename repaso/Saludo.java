class Saludo{
	private String txt;
	Saludo(String txt){
		this.txt = txt;
	}
	private void saludar(){
		System.out.println(txt);
	}
	public static void main(String [] args){
		Saludo s1 = new Saludo(args[0]);
		Saludo s2 = new Saludo(args[1]);
		Saludo s3 = new Saludo(args[2]);
		s1.saludar();
		s2.saludar();
		s3.saludar();
	}
}
