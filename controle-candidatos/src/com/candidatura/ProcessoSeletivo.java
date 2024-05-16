package com.candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	
	public static void main(String[] args) {
		System.out.println("Processo seletivo");
		
		/*analisarCandidato(1900.0);
		analisarCandidato(2200.0);
		analisarCandidato(2000.0);*/
		
		//imprimirCandidatos();
		
		String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
		
		for (String candidato : candidatos) {
			entrandoEmContato(candidato);
		}
		
	}
	
	public static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuaTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuaTentando = !atendeu;
			if (continuaTentando) {
				tentativasRealizadas++;
			}else {
				System.out.println("Contato realizado com sucesso!");
			}
		}while(continuaTentando && tentativasRealizadas<3);
		
		if (atendeu) {
			System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
		}else {
			System.out.println("Não conseguimos contato com " + candidato + " número máximo de tentativas " + tentativasRealizadas + " realizadas");
		}
	}
	
	//método auxiliar
	public static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	public static void imprimirCandidatos() {
		String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
		
		for (int i = 0; i < candidatos.length; i++) {
			System.out.println("Lista informando o índice:");
			System.out.println("O candidato de n° " + i + " é " + candidatos[i]);
		}
		
		System.out.println("==========================================");
		System.out.println("Forma abreviada de interação for each:");
		
		for (String candidato : candidatos) {
			System.out.println("O candidato selecionado foi: " + candidato);
		}
	}
	
	public static void selecaoCandidatos () {
		String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Mirela", "João"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		
		while (candidatosSelecionados < 5 && candidatoAtual <candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
			
			if (salarioBase > salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	public static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800,2200);
	}
	
	public static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0d;
		
		if (salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato.");
		}else if ( salarioBase == salarioPretendido) {
			System.out.println("Ligar para candidato com contra proposta.");
		}else {
			System.out.println("Aguardando resultado dos demais candidatos.");
		}
	}
}
