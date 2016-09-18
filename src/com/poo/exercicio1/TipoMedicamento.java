package com.poo.exercicio1;

public enum TipoMedicamento {

	UM {
		public String toString() {
			return "Solução em Capsulas/Comprimidos";
		}
	},

	DOIS {
		public String toString() {
			return "Solução Liquida";
		}
	},
	TRES {
		public String toString() {
			return "Solução Injetável";
		}
	}

}
