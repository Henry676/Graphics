class Poo{
	private String txt;
	Poo(String txt){
		this.txt = txt;
	}
	private void saludar(){
		System.out.println(txt);
	}
	public static void main(String[] args){
		Poo p = new Poo(args[0]);
		p.saludar();
	}
}
