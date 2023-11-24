package com.example.decoracoesapp.DAO;

import java.util.LinkedList;

public class TesteDAO {

    public static void main(String[] args) {

        GeralDAO dao = new GeralDAO();

        LinkedList<String> lista = dao.listarnomes();
        for (String nome : lista) {
            System.out.println(nome);
        }

        // Adicionando um funcionário.
/*		Funcionario f = new Funcionario("Lilica", "lica@email.com", "estimação");
		dao.adiciona(f);
/**/
        // Listando os funcionários.
/*		LinkedList<Funcionario> lista = dao.listar();
		for (Funcionario funcionario : lista) {
	          System.out.println(funcionario);
		}
/**/
/*
		LinkedList<Funcionario> lista = dao.procurar("maria");
		for (Funcionario funcionario : lista) {
	          System.out.println(funcionario);
		}
/**/

     /*
        LinkedList<String> lista = dao.listarNomes();
		for (String nome : lista) {
	          System.out.println(nome);
		}
        */


/*
		System.out.println("ID do funcionario a ser alterado: ");
		int id = new Scanner(System.in).nextInt();
		Funcionario f = dao.procurar(id);
		f.setNome(f.getNome()+" - alterado");
		dao.alterar(f);
/**/
    }

}




