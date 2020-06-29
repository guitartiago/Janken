package com.example.janken.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.janken.entity.Jogada;
import com.example.janken.util.JankenOption;

@Service
public class JankenService { 
	

	public Jogada realizaJogada(List<Jogada> jogadas) throws RuntimeException {
		
		if (!isJogoValido(jogadas)) {
			throw new RuntimeException("Jogo não válido");
		}
		
		Jogada jogadaVencedora = null;
		List<Jogada> jogadasTemp = new ArrayList<Jogada>(jogadas);
		
		for (Jogada jogada : jogadas) {
			jogadasTemp.remove(jogada);
			
			boolean ganhouTodas = true;
			for (Jogada jogadaTest : jogadasTemp) {
				if(!jogada.getOpcaoJogada().isWinner(jogadaTest.getOpcaoJogada())) {
					ganhouTodas = false;
					break;
				}
			}
			
			if (ganhouTodas) {
				jogadaVencedora = jogada;
				break;
			}
		}
	
		return jogadaVencedora;
	}

	private boolean isJogoValido(List<Jogada> jogadas) {
		if (jogadas != null && jogadas.size() > 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Jogada jogada1 = new Jogada("Marcia", JankenOption.TESOURA);
		Jogada jogada2 = new Jogada("Edson", JankenOption.PEDRA);
		Jogada jogada3 = new Jogada("Lucas", JankenOption.SPOCK);
		Jogada jogada4 = new Jogada("Tiago", JankenOption.PEDRA);
		
		List<Jogada> jogadas = new ArrayList<>();
		jogadas.add(jogada1);
		jogadas.add(jogada2);
		jogadas.add(jogada3);
		jogadas.add(jogada4);
		
		JankenService jkpService = new JankenService();
		Jogada jogadaVencedora = jkpService.realizaJogada(jogadas);
		
		if(jogadaVencedora != null) {
			System.out.println("O ganhandor é o " + jogadaVencedora.getJogador() + " com a jogada " + jogadaVencedora.getOpcaoJogada().getDescricao());			
		} else {
			System.out.println("Não Houve ganhadores");
		}
	}
	
}
