package TP1JAVA;

import java.util.Arrays;
import java.util.Scanner;

public class Boletim {
	
	private static String[] nomes;
	private static float[] notasav1;
	private static float[] notasav2;
	
	private static final int QTDE = 100;
	private static final float MEDIA_NOTAS = 10;
	
	private static float calcularMedia(int id) {
		return notasav1[id] + notasav2[id] / 2;
	}
	
	private static String obterSituacao(float mn) {
		return mn > MEDIA_NOTAS ? "aprovado" : "reprovado";
	}
	
	private static void imprimir(int id) {
		
		float media = calcularMedia(id);
		
		String situacao = obterSituacao(media);
		
		System.out.printf("{%d} %s - %.2f - %.2f :: media = %.2f (%s)\n",
				id, nomes[id], notasav1[id], notasav2[id], media, situacao);
		
	}
	
	private static void imprimir() {
		for (int i = 0; i < QTDE; i++) {
			if (nomes[i] != null) {
				imprimir(i);
				
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		nomes = new String[QTDE];
		notasav1 = new float[QTDE];
		notasav2 = new float[QTDE];
		
		Scanner in = new Scanner(System.in);
		
		Integer[] opcoes = {1,2,3,4};
		
		int i = 0;
		int opcao;
		do {
			System.out.println("[1] Registrar as notas de um novo Aluno");
			System.out.println("[2] Consultar boletim de um Aluno");
			System.out.println("[3] Consultar nota da Turma");
			System.out.println("[4] Sair");
			System.out.print("Informe a opcao desejada: ");
			
			opcao = in.nextInt();
			
			if(Arrays.asList(opcoes).contains(opcao)) {
				if(opcao == 1) {
					if (i < QTDE) {
						System.out.println("Informe o nome do aluno: ");
						nomes[i] = in.next();
						
						System.out.println("Informe a nota da AV1: ");
						notasav1[i] = in.nextFloat();
						
						System.out.println("Informe a nota da AV2: ");
						notasav2[i] = in.nextFloat();
						
						System.out.println("... Inclusao Realizda! ...");
						imprimir(i);
						System.out.println("... com Sucesso!...");
						
						i++;
						
					}else {
						System.out.println("Impossivel cadastrar um novo aluno!!!");
					}
				}else if (opcao == 2) {
					System.out.print("Informe a Identificacao do Aluno: ");
					int id = in.nextInt();
					
					if (id >= 0 && id < i) {
						System.out.println("..... Aluno .....");
						imprimir(id);
						System.out.println("..................");
						
					}else {
						System.out.println("Identificacao Invalida!!!");
						
					}
				}else if (opcao == 3) {
					System.out.println("... Lista de todos os Alunos ...");
					imprimir();
					System.out.println("..................");
					
				}
			
				else {
					System.out.println("Opcao Invalida!!!");
					
				}
			}
			
		} while (opcao != 4); {
			System.out.println("Sistema finalizado com sucesso!!!");
			
			
		in.close();
		}
	}

}
