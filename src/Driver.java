package binaryTree;

import javax.swing.*;

import java.awt.Component;
import java.io.*;
	
	
	
	public class Driver{
		
	
		final static JFileChooser chooser = new JFileChooser();
		static Component parent = null;
		
		public static void main(String[] args) {
			
			//árvore
			No arvore = null;
			int numero = 0;
			String operacao = null;
			int parametro = 0;
			//ENTRADA

			try{
				chooser.setMultiSelectionEnabled(true);
				
				try{
					chooser.showOpenDialog(parent);
				}catch (NullPointerException e){
					System.out.println(e.getStackTrace());
				}
				
				
				//Abrindo o arquivo passado via argumento
				FileReader fr = null;
				BufferedReader br = null;
				try{
					fr = new FileReader(chooser.getSelectedFile());
					br = new BufferedReader(fr);
				}catch (NullPointerException e){
					System.out.println(e.getStackTrace());
				}
				
				String linha = "";

				//Considerando que apenas uma linha do arquivo será levada em conta
				try{
					 linha = br.readLine();
					 System.out.println("Linha: " + linha);
				}catch (NullPointerException e){
					System.out.println(e.getMessage());
				}
				

				// while (linha != null){
					

					//Primeiro número da a raíz da Árvore
					try{
						numero = Integer.parseInt(linha.substring(0, linha.indexOf(" ")));
					}catch (StringIndexOutOfBoundsException e){
						System.out.println(e.getStackTrace());
					}
					
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
				try{
					fr.close();
				}catch (NullPointerException e){
					System.out.println(e.getStackTrace());
				}
			}catch (IOException ioe){
				System.out.println("Erro na abertura do arquivo: " + ioe.getMessage());
			}


			//INSTRUÃ‡Ã•ES

			try{
				chooser.showOpenDialog(parent);
				FileReader fr;
				BufferedReader br = null;
				try{
					fr = new FileReader(chooser.getSelectedFile());
					br = new BufferedReader(fr);
				}catch (NullPointerException e){
					System.out.println("error");
				}
				
				String linha = "";
				try{
					linha  = br.readLine();
				}catch (NullPointerException e){
					System.out.println("error");
				}

				while (linha != null){
					System.out.println("Linha: " + linha);

					try{
						operacao = linha.substring(0, linha.indexOf(" "));
					}catch (StringIndexOutOfBoundsException e){
						System.out.println("erro");
					}

					if (operacao == "ENESIMO" || operacao == "POSICAO" || operacao == "REMOVA"){
						linha = linha.substring(linha.indexOf(" ")+1, linha.length());
						parametro = Integer.parseInt(linha.substring(0, linha.length()));
					}

					try{
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
							System.out.println(arvore.remover(parametro) ? "Removido o valor " + parametro : "O valor não pode ser removido.");
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
					}catch (NullPointerException e){
						System.out.println("erro");
					}
					try{
						linha = br.readLine();
					}catch(NullPointerException e){
						System.out.println("erro");
						break;
					}

				}
			}catch (IOException ioe){
				System.out.println("Erro na abertura do arquivo: " + ioe.getMessage());
			}

		}

	}
