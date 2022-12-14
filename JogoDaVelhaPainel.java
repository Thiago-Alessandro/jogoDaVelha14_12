package atividade14_12;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class JogoDaVelhaPainel {

static String posicoes [] = new String[9];
	
	public static void main(String[] args) {
		
		boolean partidaFinalizada = false;
		int posicao, jogador = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		do {
			
			posicao = Integer.parseInt(JOptionPane.showInputDialog("\n\tJogador " + jogadorVerificador(jogador) + "\n\t   __________________\n\n\tQual posição deseja jogar?\n\n\t      1  |  2  |  3  \n\t"
			+ "      4  |  5  |  6  \n\t      7  |  8  |  9  \n\n\t   __________________"));
			
			jogador = jogador(jogador, posicao);
			posicoes = prepararJogo();
			
			posicoes = verificarPosicao(posicao, jogador);
			jogoDaVelha();
			
			partidaFinalizada = verificadorFimPartida(partidaFinalizada, jogador);
			
		} while(partidaFinalizada == false);
		
		
		
	}
	public static String[] verificarPosicao (int posicao, int jogador) {
		
		if (jogador % 2 == 0 && posicoes[posicao - 1] == " ") {
			
			posicoes[posicao - 1] = "X";
			
		} else if(posicoes[posicao - 1] == " "){
			
			posicoes[posicao - 1] = "O";
			
		}
		
		return posicoes;
		
	}
	

	public static void jogoDaVelha() {
		
		
		
		JOptionPane.showMessageDialog(null, "\t      " + posicoes[0] + "  |  " + posicoes[1] + "  |  " + posicoes[2] + "  "  +
											"\n\t    -----------------" +
										 	"\n\t      " + posicoes[3] + "  |  " + posicoes[4] + "  |  " + posicoes[5] + "  " + 
											"\n\t    -----------------" +
											"\n\t      " + posicoes[6] + "  |  " + posicoes[7] + "  |  " + posicoes[8] + "  ");
		
	}
	
	public static int jogador(int jogador, int posicao) {
		
		if (posicoes[posicao - 1] == " " || posicoes[posicao - 1] == null) {
			
			jogador++;
			
		} else {
			
			JOptionPane.showMessageDialog(null, "\tA posição " + posicao + " já foi escolhida.\n");
			
		}
		
		return jogador;
	}
	
	public static String[] prepararJogo() {
		
		for (int c = 0; c < posicoes.length; c++) {
			
			if(posicoes[c] == null){
				
				posicoes[c] = " ";
				
			}	
		}
		
		return posicoes;
	}
	public static boolean verificadorFimPartida(boolean partidaFinalizada, int jogador) {
		
		if (jogador == 9) {
			
			partidaFinalizada = true;
			JOptionPane.showMessageDialog(null, "\n\t\tDeu Velha!\n");
			
		} else if (posicoes[0] == posicoes[1] && posicoes[1] == posicoes[2] && posicoes[0] == "X" ||
					posicoes[0] == posicoes[3] && posicoes[3] == posicoes[6] && posicoes[0] == "X" ||
					posicoes[0] == posicoes[4] && posicoes[4] == posicoes[8] && posicoes[0] == "X" ||
					posicoes[1] == posicoes[4] && posicoes[4] == posicoes[7] && posicoes[4] == "X" ||
					posicoes[2] == posicoes[5] && posicoes[5] == posicoes[8] && posicoes[8] == "X" ||
					posicoes[3] == posicoes[4] && posicoes[4] == posicoes[5] && posicoes[4] == "X" ||
					posicoes[6] == posicoes[7] && posicoes[7] == posicoes[8] && posicoes[8] == "X" ||
					posicoes[2] == posicoes[4] && posicoes[4] == posicoes[6] && posicoes[4] == "X" ) {
			
			partidaFinalizada = true;
			JOptionPane.showMessageDialog(null, "\n\tO jogador 1 é vencedor!\n");
			
		} else if (posicoes[0] == posicoes[1] && posicoes[1] == posicoes[2] && posicoes[0] == "O" ||
					posicoes[0] == posicoes[3] && posicoes[3] == posicoes[6] && posicoes[0] == "O" ||
					posicoes[0] == posicoes[4] && posicoes[4] == posicoes[8] && posicoes[0] == "O" ||
					posicoes[1] == posicoes[4] && posicoes[4] == posicoes[7] && posicoes[4] == "O" ||
					posicoes[2] == posicoes[5] && posicoes[5] == posicoes[8] && posicoes[8] == "O" ||
					posicoes[3] == posicoes[4] && posicoes[4] == posicoes[5] && posicoes[4] == "O" ||
					posicoes[6] == posicoes[7] && posicoes[7] == posicoes[8] && posicoes[8] == "O" ||
					posicoes[2] == posicoes[4] && posicoes[4] == posicoes[6] && posicoes[4] == "O" ) {
		
			partidaFinalizada = true;
			JOptionPane.showMessageDialog(null, "\n\tO jogador 2 é vencedor!\n");
			
		}
		
		return partidaFinalizada;
	}
	
	public static int jogadorVerificador (int jogador) {
		
		 int jogadorVerificado = 0;
		
		if (jogador % 2 == 0) {
			
			jogadorVerificado = 1;
			
		} else {
			
			jogadorVerificado = 2;
		}
		
		return jogadorVerificado;
	}

}
