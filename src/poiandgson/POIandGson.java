/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poiandgson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import poiandgson.Pessoa.Pessoa;

/**
 *
 * @author queir
 */
public class POIandGson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("Alex egidio");

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(25);
		pessoa2.setNome("Marcos tadeu");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(40);
		pessoa3.setNome("Maria jesus");

                /*Após ter esse arquivo em mãos, ele pode ser enviado para um e-mail , banco etc*/
                
		/*Pode vir do banco de dados ou qualquer fonte de dados*/
		      List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		File arquivo = new File("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\arquivo.txt");

		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}

		FileWriter escrever_no_arquivo = new FileWriter(arquivo);

		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}

		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
    }
    
}
