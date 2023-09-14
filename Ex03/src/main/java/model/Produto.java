package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Produto {
	private int id;
	private String nome;
	private float preco;
	private int quantidade;
	private LocalDateTime dataVenda;	
	private LocalDate prazoEntrega;
	
	public Produto() {
		id = -1;
		nome = "";
		preco = 0.00F;
		quantidade = 0;
		dataVenda = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
		prazoEntrega = LocalDate.now().plusMonths(6); // o default é uma validade de 6 meses.
	}

	public Produto(int id, String nome, float preco, int quantidade, LocalDateTime venda, LocalDate e) {
		setId(id);
		setNome(nome);
		setPreco(preco);
		setQuantidade(quantidade);
		setDataVenda(venda);
		setPrazoEntrega(e);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public LocalDate getPrazoEntrega() {
		return prazoEntrega;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		// Pega a Data Atual
		LocalDateTime agora = LocalDateTime.now();
		// Garante que a data de venda não pode ser futura
		if (agora.compareTo(dataVenda) >= 0)
			this.dataVenda = dataVenda;
	}

	public void setPrazoEntrega(LocalDate prazoEntrega) {
		// a data de venda deve ser anterior ao prazo de entrega.
		if (getDataVenda().isBefore(prazoEntrega.atStartOfDay()))
			this.prazoEntrega = prazoEntrega;
	}

	public boolean emPrazo() {
		return LocalDateTime.now().isBefore(this.getPrazoEntrega().atTime(23, 59));
	}


	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Produto: " + nome + "   Preço: R$" + preco + "   Quantidade.: " + quantidade + "   Venda: "
				+ dataVenda  + "   Prazo de Entrega: " + prazoEntrega;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Produto) obj).getID());
	}	
}