package com.poo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;



public class Farmacia {
	static Random gerador = new Random();
	static Medicamento medicamento;
	static List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	public static void main(String[] args) {
		menu();
	}
	public static void menu(){
		int op = getOption();
		switch (op) {
		case 0:
			JOptionPane.showMessageDialog(null, "Tchau!");
			break;
		case 1:
			medicamentos.add(cadastrarMedicamentos());
			menu();
			break;
		case 2:
			imprimirMedicamentos();
			menu();
			break;
		case 3:
			consultaMedicamento();
			menu();
			break;
		default:
			System.err.println("Opção inválida");
			break;
		}
		
	}


	public static int getOption(){
		 String[] options = new String[] {"Finalizar Aplicação","Cadastrar Medicamento", "Imprimir medicamentos","Consulta medicamento"};
		    int response = JOptionPane.showOptionDialog(null, "Informe o que deseja", "Sistema de cadastro",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		return response;
	}
	public static void menuTipo(){
		int op = getOptionTipo();
		switch (op) {
		case 0:
			JOptionPane.showMessageDialog(null, "Nao Decidiu!");
			break;
		case 1:
			medicamento.setTipo(TipoMedicamento.UM);
			break;
		case 2:
			medicamento.setTipo(TipoMedicamento.DOIS);
			break;
		case 3:
			medicamento.setTipo(TipoMedicamento.TRES);
			break;
		default:
			System.err.println("Opção inválida!");
			break;
		}
		
	}
	public static int getOptionTipo() {
		String[] opcao = new String[] { "Não Sei", "Tipo 1", "Tipo 2","Tipo 3" };
		int resposta = JOptionPane.showOptionDialog(null, "Informe o Tipo", "Tipos de Medicamentos",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
		return resposta;
	}
	
	public static Medicamento cadastrarMedicamentos() {
		medicamento = new  Medicamento();
		medicamento.setCodigo(JOptionPane.showInputDialog("Codigo do medicamento"));
		medicamento.setNome(JOptionPane.showInputDialog("Nome do medicamento"));
		medicamento.setDescricao(JOptionPane.showInputDialog("Descricao do medicamento"));
		menuTipo();
		medicamento.setPreco(Double.valueOf(JOptionPane.showInputDialog("Preco do medicamento")));
		medicamento.setEstoque(
					
						gerador.nextInt(51)
				);
		
		
		return medicamento;
	}

	private static void imprimirMedicamentos() {
		String aux = "";
		int cont = 1;
		boolean bl = false;
		for (Medicamento d : medicamentos) {
			if (d == null){
				bl=false;
				break;
			}
			bl = true;
			aux += "\n\n"+cont+" Código: " + d.getCodigo() +"\nNome: "+d.getNome()
					+"\nDescricao: "+d.getDescricao()+"\nTipo: "+d.getTipo()+"\nEstoque: "+d.getEstoque();
			cont++;
		}
		if (bl == true)
			JOptionPane.showMessageDialog(null,aux);
		else
		JOptionPane.showMessageDialog(null,"Lista vazia");
	}

	private static void consultaMedicamento() {
		String resposta = JOptionPane.showInputDialog("Descricao do medicamento",JOptionPane.YES_OPTION); 
		if(medicamentos.isEmpty()){
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		}
		else{
			for (Medicamento medicamentos : medicamentos) {
				if(resposta.equals(medicamentos.getNome()) )
					JOptionPane.showMessageDialog(null, "\n\n"+"Codigo: "+medicamentos.getCodigo()
							+"Nome: "+medicamentos.getNome());
				
			}
		}		
	}
}
