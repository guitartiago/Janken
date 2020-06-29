package com.example.janken.entity;

import com.example.janken.util.JankenOption;

public class Jogada {
	
	private String jogador;
	private JankenOption opcaoJogada;
	
	public Jogada(String jogador, JankenOption opcaoJogada) {
		this.jogador = jogador;
		this.opcaoJogada = opcaoJogada;
	}
	
	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	
	public JankenOption getOpcaoJogada() {
		return opcaoJogada;
	}
	
	public void setOpcaoJogada(JankenOption opcaoJogada) {
		this.opcaoJogada = opcaoJogada;
	}
}
