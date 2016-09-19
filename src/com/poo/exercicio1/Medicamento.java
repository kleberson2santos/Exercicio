package com.poo.exercicio1;

public class Medicamento implements Cloneable{

	private String codigo;
	private String nome;
	private String descricao;
	private TipoMedicamento tipo;
	private Double preco;
	private int estoque;
	
	public Medicamento(String codigo, String nome, String descricao, 
			TipoMedicamento tipo, Double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public Medicamento() { 
	}
	@Override
    public Medicamento clone() throws CloneNotSupportedException {
        return (Medicamento) super.clone();
    }

	public void imprimir(){
		System.out.println("Codigo: "+this.codigo);
		System.out.println("Medicamento: "+this.nome);
		System.out.println("Descricao: "+this.descricao);
		System.out.println("Tipo: "+this.tipo);
		System.out.println("Preco: "+this.preco);
		System.out.println("Estoque: "+this.estoque);
		System.out.println("\n");
	}
	
	public void aplicarDesconto(Double valor){
		this.preco=this.preco-((this.preco*valor)/100);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	

}
