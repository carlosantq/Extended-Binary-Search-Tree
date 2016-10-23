
public class Driver {

	public static void main(String[] args) {
		
		System.out.println("Foi!");
		
		No raiz = new No(30);
		raiz.adicionar(10);
		raiz.adicionar(50);
		raiz.adicionar(70);
		raiz.adicionar(1);
		raiz.adicionar(20);
		raiz.adicionar(40);
		raiz.adicionar(0);
		raiz.adicionar(5);
		raiz.adicionar(15);
		raiz.adicionar(25);
		raiz.adicionar(35);
		raiz.adicionar(45);
		raiz.adicionar(60);
		raiz.adicionar(100);
		
		System.out.println(raiz.toString());		
	}

}
