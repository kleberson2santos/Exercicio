package com.poo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;



public class Farmacia {
	static Random gerador = new Random();
	static Medicamento medicamento = new Medicamento();
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
			imprimirMedicamentos(medicamentos);
			menu();
			break;
		default:
			System.err.println("Opção inválida");
			break;
		}
		
	}
	public static int getOption(){
		 String[] options = new String[] {"Finalizar Aplicação","Cadastrar Medicamento", "Imprimir medicamentos"};
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
	public static void imprimirMedicamentos(List<Medicamento> medicamentos){
		for(Medicamento medicamento: medicamentos){
			medicamento.imprimir();
		}
	}

}
