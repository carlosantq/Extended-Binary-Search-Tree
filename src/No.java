import java.util.LinkedList;
import java.util.Queue;

public class No {
	// Atributos
	int valor;
	No esq;
	No dir;
	
	// Construtor
	public No(int valor) {
		this.valor = valor;
		esq = null;
		dir = null;
		System.out.println("Nó criado com o valor " + valor + ".");
	}
	
	// Metodos
	public Boolean adicionar(int novoValor) {
		// Novo valor maior que raiz
		if (novoValor > valor) {
			if (dir == null) {
				dir = new No(novoValor);
				System.out.println("Nó " + novoValor + " adicionado a direita de " + valor + ".");
				return true;
			}
			else {
				dir.adicionar(novoValor);
			}
		}
		// Novo valor menor que raiz
		else if (novoValor < valor) {
			if (esq == null) {
				esq = new No(novoValor);
				System.out.println("Nó " + novoValor + " adicionado a esquerda de " + valor + ".");
				return true;
			}
			else {
				esq.adicionar(novoValor);
			}
		}
		// Novo valor igual a raiz
		else {
			return false;
		}
		
		return false;
	}

	public Boolean remover(int valor) {
		return false;		
	}
	
	public Boolean procurar(int valor) {
		// Nao achou
		if (valor != this.valor && esq == null && dir == null) {
			return false;
		}
		// Achou
		else if (valor == this.valor) {
			return true;
		}
		// Valor eh maior que raiz
		else if (valor > this.valor) {
			dir.procurar(valor);
		}
		else if (valor < this.valor) {
			esq.procurar(valor);
		}
		
		return false;
	}
	
	public int enesimoElemento(int valor) {
		return 0;
	}
	
	public int posicao(int valor) {
		return 0;
	}
	
	public int mediana() {
		return 0;
	}
	
	public Boolean ehCheia() {
		return false;
	}
	
	public Boolean ehCompleta() {
		return false;
	}
	
	public String toString() {
		// Fila utilizada no percorrimento em nível da arvore
		Queue<No> fila = new LinkedList<No>();
		// String a ser retornada
		String retorno = "";
		
		// Adiciona raiz a fila
		fila.add(this);
		
		// Enquanto a fila nao esta vazia, enfila os filhos do primeiro elemento
		// da fila e depois concatena o primeiro elemento na string retorno.
		while (!fila.isEmpty()) {
			
			try {
				fila.offer(fila.peek().esq);
			}
			catch (NullPointerException e){}
			
			try {
				fila.offer(fila.peek().dir);
			}
			catch (NullPointerException e){}
			
			try {
				retorno = retorno + fila.peek().valor + " ";
			}
			catch (NullPointerException e){}
			
			fila.poll();
		}
		// Apaga o ultimo espaco
		retorno = retorno.substring(0, retorno.length()-1);
		
		return retorno;
	}
	
	
}
