package br.edu.atitus.currency_service.clients;

import java.util.List;

public class CurrencyBCResponse {
	private List<Currency> value;

	//Getters and Setters
	
	public List<Currency> getValue() {
		return value;
	}

	public void setValue(List<Currency> value) {
		this.value = value;
	}
	
	public static class Currency {
		private double cotacaoVenda;

		// Getters and Setters
		
		public double getCotacaoVenda() {
			return cotacaoVenda;
		}

		public void setCotacaoVenda(double cotacaoVenda) {
			this.cotacaoVenda = cotacaoVenda;
		}
		
	}
}
