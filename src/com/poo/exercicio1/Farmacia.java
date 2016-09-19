package com.poo.exercicio1;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Farmacia {
	static Random gerador = new Random();
	static Medicamento medicamento;
	static Medicamento item;
	static List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	static List<Medicamento> cesta = new ArrayList<Medicamento>();

	public static void main(String[] args) throws CloneNotSupportedException {
		menu();
	}

	public static void menu() throws CloneNotSupportedException {

		int op = getOpcaoMenu();
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
		case 4:
			adicionaNaCesta();
			menu();
			break;
		case 5:
			imprimirCesta();
			menu();
			break;
		case 6:
			retiraDaCesta();
			menu();
			break;
		default:
			System.err.println("Opção inválida");
			break;
		}

	}

	public static int getOpcaoMenu() {
		String[] options = new String[] { "SAIR", "Cadastrar", "Listar",
				"Procurar", "Adicionar à Cesta", "Imprimir Cesta", "Retirar da Cesta" };
		int response = JOptionPane.showOptionDialog(null, "Informe o que deseja", "Sistema de cadastro",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		return response;
	}

	public static void menuTipo() {
		int op = getOpcaoTipo();
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

	public static int getOpcaoTipo() {
		String[] opcao = new String[] { "Não Sei", "Tipo 1", "Tipo 2", "Tipo 3" };
		int resposta = JOptionPane.showOptionDialog(null, "Informe o Tipo", "Tipos de Medicamentos",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
		return resposta;
	}

	public static Medicamento cadastrarMedicamentos() {
		medicamento = new Medicamento();
		medicamento.setCodigo(JOptionPane.showInputDialog("Codigo do medicamento"));
		medicamento.setNome(JOptionPane.showInputDialog("Nome do medicamento"));
		medicamento.setDescricao(JOptionPane.showInputDialog("Descricao do medicamento"));
		menuTipo();
		medicamento.setPreco(Double.valueOf(JOptionPane.showInputDialog("Preco do medicamento")));
		medicamento.setEstoque(

				gerador.nextInt(51));

		return medicamento;
	}

	private static void imprimirMedicamentos() {
		String aux = "";
		int cont = 1;
		boolean bl = false;
		for (Medicamento d : medicamentos) {
			if (d == null) {
				bl = false;
				break;
			}
			bl = true;
			aux += "\n\n" + cont + " Código: " + d.getCodigo() + "\nNome: " + d.getNome() + "\nDescricao: "
					+ d.getDescricao() + "\nTipo: " + d.getTipo() + "\nEstoque: " + d.getEstoque() + "\nPreco: "
					+ d.getPreco();
			cont++;
		}
		if (bl == true)
			JOptionPane.showMessageDialog(null, aux);
		else
			JOptionPane.showMessageDialog(null, "Lista vazia");
	}

	private static void imprimirCesta() {
		String aux = "";
		int cont = 1;
		boolean bl = false;
		for (Medicamento d : cesta) {
			if (d == null) {
				bl = false;
				break;
			}
			bl = true;
			aux += "\n\n" + cont + " Código: " + d.getCodigo() + "\nNome: " + d.getNome() + "\nDescricao: "
					+ d.getDescricao() + "\nTipo: " + d.getTipo() + "\nPreco: "
					+ d.getPreco();
			cont++;
		}
		if (bl == true)
			JOptionPane.showMessageDialog(null, aux);
		else
			JOptionPane.showMessageDialog(null, "Lista vazia");
	}

	private static void consultaMedicamento() {
		if (medicamentos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		} else {
			String resposta = JOptionPane.showInputDialog("Descricao do medicamento", JOptionPane.YES_OPTION);
			for (Medicamento medicamento : medicamentos) {
				if (resposta.equals(medicamento.getNome()))
					JOptionPane.showMessageDialog(null,
							"\n\n" + "Codigo: " + medicamento.getCodigo() + " Nome: " + medicamento.getNome()
									+ " Preco:" + medicamento.getPreco() + " Estoque:" + medicamento.getEstoque());

			}
		}
	}

	private static void adicionaNaCesta() throws CloneNotSupportedException {
		if (medicamentos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		} else {
			item = new Medicamento();
			String resposta = JOptionPane.showInputDialog("Qual o código para adicionar?", JOptionPane.YES_OPTION);
			item = medicamento.clone();

			for (Medicamento m : medicamentos) {
				if (resposta.equals(m.getCodigo())) {

					item = m.clone();
					item.aplicarDesconto((Double.valueOf(JOptionPane.showInputDialog("Valor do desconto?",0))));
					cesta.add(item);
					m.setEstoque(m.getEstoque() - 1);
					JOptionPane.showMessageDialog(null, "\n\n" + "Codigo: " + item.getCodigo() + " Nome: "
							+ item.getNome() + "\n\nAdicionado à Cesta!");
				}
			}
		}
	}

	private static void retiraDaCesta() {
		if (cesta.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		} else {
			String resposta = JOptionPane.showInputDialog("Qual o código para remover?", JOptionPane.YES_OPTION);
			for (Medicamento m : cesta) {
				if (resposta.equals(m.getCodigo())) {
					try {
						cesta.remove(m);
						break;
					} finally {
						JOptionPane.showMessageDialog(null, "\nRemovido da Cesta!");
					}
				}
			}
		}
	}
}
