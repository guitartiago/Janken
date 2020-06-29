package com.example.janken.util;

public enum JankenOption {
	PAPEL("papel") {
		@Override
		public boolean isWinner(JankenOption otherOption) {
			if (SPOCK.equals(otherOption) || PEDRA.equals(otherOption)) {
				return true;	
			}
			return false;
		}
	},
	PEDRA("pedra") {
		@Override
		public boolean isWinner(JankenOption otherOption) {
			if (TESOURA.equals(otherOption) || LAGARTO.equals(otherOption)) {
				return true;	
			}
			return false;
		}
	},
	TESOURA("tesoura") {
		@Override
		public boolean isWinner(JankenOption otherOption) {
			if (PAPEL.equals(otherOption) || LAGARTO.equals(otherOption)) {
				return true;	
			}
			return false;
		}
	},
	LAGARTO("lagarto") {
		@Override
		public boolean isWinner(JankenOption otherOption) {
			if (SPOCK.equals(otherOption) || PAPEL.equals(otherOption)) {
				return true;	
			}
			return false;
		}	
	},
	SPOCK("spock") {
		@Override
		public boolean isWinner(JankenOption otherOption) {
			if (TESOURA.equals(otherOption) || PEDRA.equals(otherOption)) {
				return true;	
			}
			return false;
		}		
	};
	
	private String descricao;
	
	private JankenOption(String descricao) {
		this.descricao = descricao;
	}

	public abstract boolean isWinner(JankenOption otherOption);
	
	public String getDescricao(){
		return this.descricao;
	}
	
}
