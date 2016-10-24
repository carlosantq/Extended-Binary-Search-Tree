import java.util.*;
import java.io.*;

public class Driver {
	public static void main(String[] args) {

		//Árvore
		No arvore = null;
		int numero;

		if (args.length < 1){
			System.out.println("Erro! Arquivo de entrada não informado.");
		}

		try{
			//Abrindo o arquivo passado via argumento
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);

			//Considerando que apenas uma linha do arquivo será levada em conta
			String linha = br.readLine();

			// while (linha != null){
				System.out.println("Linha: " + linha);

				//Primeiro número é a raíz da árvore
				numero = Integer.parseInt(linha.substring(0, linha.indexOf(" ")));
				arvore = new No(numero);

				linha = linha.substring(linha.indexOf(" ")+1, linha.length());

				//Adicionando números do arquivo restantes na árvore criada anteriormente
				while (linha.length() > 0){
					numero = Integer.parseInt(linha.substring(0, linha.indexOf(" ")));
					arvore.adicionar(numero);
					linha = linha.substring(linha.indexOf(" ")+1, linha.length());
				}

				// linha = br.readLine();
			// }
			fr.close();
		}catch (IOException ioe){
			System.out.println("Erro na abertura do arquivo: " + ioe.getMessage());
		}

		//Imprimindo a árvore (depuração)
		System.out.println(arvore.toString());
	}
}
