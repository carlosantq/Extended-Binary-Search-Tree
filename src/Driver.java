import java.util.*;
import java.io.*;

public class Driver {
	public static void main(String[] args) {

		//Árvore
		No arvore = null;
		int numero;
		String operacao;
		int parametro = 0;

		if (args.length < 2){
			System.out.println("Erro! Arquivos de entrada não informados.");
		}

		//ENTRADA

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


		//INSTRUÇÕES

		try{
			FileReader fr = new FileReader(args[1]);
			BufferedReader br = new BufferedReader(fr);

			String linha = br.readLine();

			while (linha != null){
				System.out.println("Linha: " + linha);

				operacao = linha.substring(0, linha.indexOf(" "));

				if (operacao.equals("ENESIMO") || operacao.equals("POSICAO") || operacao.equals("REMOVA")){
					linha = linha.substring(linha.indexOf(" ")+1, linha.length());
					parametro = Integer.parseInt(linha.substring(0, linha.length()));
				}

				switch(operacao){
					case "IMPRIMA":
						System.out.println(arvore.toString());
						break;
					case "ENESIMO":
						System.out.println(arvore.enesimoElemento(parametro));
						break;
					case "POSICAO":
						System.out.println(arvore.posicao(parametro));
						break;
					case "REMOVA":
						System.out.println(arvore.remover(parametro) ? "Removido o valor " + parametro : "O valor não pôde ser removido.");
						break;
					case "MEDIANA":
						System.out.println(arvore.mediana());
						break;
					case "CHEIA":
						System.out.println(arvore.ehCheia() ? "É Cheia" : "Não é cheia");
						break;
					case "COMPLETA":
						System.out.println(arvore.ehCompleta() ? "É Completa" : "Não é completa");
						break;	
				}

				linha = br.readLine();

			}
		}catch (IOException ioe){
			System.out.println("Erro na abertura do arquivo: " + ioe.getMessage());
		}

		arvore.print();

	}
}
