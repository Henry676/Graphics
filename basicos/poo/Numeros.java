package p1.basicos.poo;

class Numeros {
//--------------Atributos o propiedades
    private double n1, n2;
//--------------Comportamiento o metodos
    public Numeros(double n1, double n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    private void imprimir(){
        if(n1>n2){
            System.out.println("El numero "+n1+" es mayor que "+n2);
        }else{
            System.out.println("El numero "+n2+" es mayor que "+n1);
        }
    }
//-------------Main-----------------
    public static void main(String[] args) {
	double n1 = Math.random();
	double n2 = Math.random();
        Numeros n = new Numeros(n1,n2);
        n.imprimir();
    }
}
